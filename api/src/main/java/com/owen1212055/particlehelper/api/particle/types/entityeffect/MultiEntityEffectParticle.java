package com.owen1212055.particlehelper.api.particle.types.entityeffect;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractMultiParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;

public class MultiEntityEffectParticle extends AbstractMultiParticle {

    private float colorMultiplier;

    public MultiEntityEffectParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    public float getColorMultiplier() {
        return colorMultiplier;
    }

    public void setColorMultiplier(float colorMultiplier) {
        this.colorMultiplier = colorMultiplier;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.speed = colorMultiplier;

        return simpleCompiledParticle.compileSender();
    }

}
