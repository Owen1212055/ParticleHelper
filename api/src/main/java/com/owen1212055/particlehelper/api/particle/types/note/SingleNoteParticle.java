package com.owen1212055.particlehelper.api.particle.types.note;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.particle.types.ColorableParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Color;
import org.jetbrains.annotations.NotNull;

public class SingleNoteParticle extends AbstractSingleParticle<SingleNoteParticle> implements ColorableParticle<SingleNoteParticle> {

    private Color color;
    private float magicColor;

    public SingleNoteParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public Color color() {
        return color;
    }

    /**
     * Note this is an imperfect implementation and tries
     * to give the best possible color that matches.
     * @param color color
     */
    @NotNull
    @Override
    public SingleNoteParticle color(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        float maxChannel = max(r, g, b);
        float minChannel = min(r, g, b);

        if (maxChannel == minChannel) {
            this.magicColor = 33000;
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
            this.magicColor = -hue + 0.25f;
        }

        // Get client interp
        float magic = (float) (Math.PI * 2F);
        int red = (int) Math.max(0.0F, Math.sin((this.magicColor * magic)) * 0.65F + 0.35F) * 255;
        int green = (int) Math.max(0.0F, Math.sin((this.magicColor + 0.33333334F) * magic) * 0.65F + 0.35F) * 255;
        int blue = (int) Math.max(0.0F, Math.sin((this.magicColor + 0.6666667F) * magic) * 0.65F + 0.35F) * 255;

        this.color = Color.fromRGB(red, green, blue);

        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.magicColor;
        simpleCompiledParticle.speed = 1; // Keep speed constant

        return simpleCompiledParticle.compileSender();
    }

    private static int max(int... numbers) {
        int max = numbers[0];

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }

    private static int min(int... numbers) {
        int min = numbers[0];

        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }

        return min;
    }

}
