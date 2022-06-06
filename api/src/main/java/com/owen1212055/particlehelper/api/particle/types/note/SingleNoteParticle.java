package com.owen1212055.particlehelper.api.particle.types.note;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.particle.types.ColorableParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Color;

public class SingleNoteParticle extends AbstractSingleParticle implements ColorableParticle {

    private Color color;
    private float hue;

    public SingleNoteParticle(ParticleType<?, ?> particleType) {
        super(particleType);
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

    @Override
    public Color getColor() {
        return color;
    }

    // TODO: try to clean up this implementation
    @Override
    public void setColor(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        float maxChannel = (float) max(r, g, b);
        float minChannel = (float) min(r, g, b);

        if (maxChannel == minChannel) {
            this.hue = 33000;
        } else {
            float redChannel = (maxChannel - r) / (maxChannel - minChannel);
            float greenChannel = (maxChannel - g) / (maxChannel - minChannel);
            float blueChannel = (maxChannel - b) / (maxChannel - minChannel);

            float hue;
            if (r == maxChannel) {
                hue = blueChannel - greenChannel;
            } else if (g == maxChannel) {
                hue = 2.0f + redChannel - blueChannel;
            } else {
                hue = 4.0f + greenChannel - redChannel;
            }
            hue = hue / 6.0f;
            if (hue < 0) {
                hue = hue + 1.0f;
            }
            this.hue = -hue + 0.25f;
        }

        // Get client interp
        float magic = (float) (Math.PI * 2F);
        int red = (int) Math.max(0.0F, Math.sin((this.hue * magic)) * 0.65F + 0.35F) * 255;
        int green = (int) Math.max(0.0F, Math.sin((this.hue + 0.33333334F) * magic) * 0.65F + 0.35F) * 255;
        int blue = (int) Math.max(0.0F, Math.sin((this.hue + 0.6666667F) * magic) * 0.65F + 0.35F) * 255;

        this.color = Color.fromRGB(red, green, blue);
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.hue;
        simpleCompiledParticle.speed = 1; // Keep speed constant

        return simpleCompiledParticle.compileSender();
    }

}
