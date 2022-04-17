package com.owen1212055.particlehelper.api.particle.types.note;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.*;

public class SingleNoteParticle extends AbstractSingleParticle implements ColorableParticle {

    public SingleNoteParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    private Color color;
    private float hue;

    @Override
    public Color getColor() {
        return color;
    }

    // TODO: try to clean up this implementation
    @Override
    public void setColor(Color color) {
        float hue;
        float saturation;

        int R = color.getRed();
        int G = color.getGreen();
        int B = color.getBlue();

        float maxChannel = (float) max(R, G, B);
        float minChannel = (float) min(R, G, B);

        if (maxChannel == minChannel) {
            // TODO:
            this.hue = 33000;
            return;
        }

        if (maxChannel != 0f) {
            saturation = (maxChannel - minChannel) / maxChannel;
        } else {
            saturation = 0f;
        }
        float redChannel = (maxChannel - R) / (maxChannel - minChannel);
        float greenChannel = (maxChannel - G) / (maxChannel - minChannel);
        float blueChannel = (maxChannel - B) / (maxChannel - minChannel);
        if (R == maxChannel) {
            hue = blueChannel - greenChannel;
        } else if (G == maxChannel) {
            hue = 2.0f + redChannel - blueChannel;
        } else {
            hue = 4.0f + greenChannel - redChannel;
        }
        hue = hue / 6.0f;
        if (hue < 0) {
            hue = hue + 1.0f;
        }
        this.hue = -hue + 0.25f;
        if (saturation == 1.0f && maxChannel == 255f) {
            this.color = color;
            return;
        }

        float h = (hue - (float) Math.floor(hue)) * 6.0f;
        float f = h - (float) Math.floor(h);
        float q = 1.0f - f;
        float t = 1.0f - (1.0f - f);
        switch ((int) h) {
            case 0 -> {
                R = 255;
                G = (int) (t * 255.0f + 0.5f);
                B = 0;
            }
            case 1 -> {
                R = (int) (q * 255.0f + 0.5f);
                G = 255;
                B = 0;
            }
            case 2 -> {
                R = 0;
                G = 255;
                B = (int) (t * 255.0f + 0.5f);
            }
            case 3 -> {
                R = 0;
                G = (int) (q * 255.0f + 0.5f);
                B = 255;
            }
            case 4 -> {
                R = (int) (t * 255.0f + 0.5f);
                G = 0;
                B = 255;
            }
            case 5 -> {
                R = 255;
                G = 0;
                B = (int) (q * 255.0f + 0.5f);
            }
        }

        this.color = Color.fromBGR((R << 16) | (G << 8) | B);
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.hue;
        simpleCompiledParticle.speed = 1; // Keep speed constant

        return simpleCompiledParticle.compileSender();
    }

    private static double max(double... numbers) {
        double max = numbers[0];

        for (double number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }

    private static double min(double... numbers) {
        double min = numbers[0];

        for (double number : numbers) {
            if (number < min) {
                min = number;
            }
        }

        return min;
    }

}
