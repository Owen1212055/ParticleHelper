package com.owen1212055.particlehelper.api.particle.types.entityeffect;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractMultiParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.jetbrains.annotations.NotNull;

public class MultiEntityEffectParticle extends AbstractMultiParticle<MultiEntityEffectParticle> {

    private float colorMultiplier;

    public MultiEntityEffectParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    public float colorMultiplier() {
        return colorMultiplier;
    }

    public MultiEntityEffectParticle colorMultiplier(float colorMultiplier) {
        this.colorMultiplier = colorMultiplier;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.speed = colorMultiplier;

        return simpleCompiledParticle.compileSender();
    }

}
