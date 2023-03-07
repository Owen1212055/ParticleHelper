package com.owen1212055.particlehelper.api.particle.types.entityeffect;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.particle.types.ColorableParticle;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.SingleRisingParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Color;
import org.jetbrains.annotations.NotNull;

/**
 * It should be noted that these particle share the same properties as {@link SingleRisingParticle}
 * This means that the more green the color is, the "less random" the particle will appear.
 */
public class SingleEntityEffectParticle extends AbstractSingleParticle<SingleEntityEffectParticle> implements ColorableParticle<SingleEntityEffectParticle> {

    private Color color = Color.WHITE;

    public SingleEntityEffectParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public Color color() {
        return this.color;
    }

    @NotNull
    @Override
    public SingleEntityEffectParticle color(Color color) {
        this.color = color;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle compiledParticle = new SimpleCompiledParticle(this);
        compiledParticle.speed = 1; // Leave the color
        compiledParticle.offsetX = color.getRed() / 255F;
        compiledParticle.offsetY = color.getGreen() / 255F;
        compiledParticle.offsetZ = color.getBlue() / 255F;

        return compiledParticle.compileSender();
    }

}
