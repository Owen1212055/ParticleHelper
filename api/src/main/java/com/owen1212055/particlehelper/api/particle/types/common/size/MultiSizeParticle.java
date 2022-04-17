package com.owen1212055.particlehelper.api.particle.types.common.size;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;

public class MultiSizeParticle extends AbstractMultiParticle {

    private float sizeMultiplier;

    public MultiSizeParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    public float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    public void setSizeMultiplier(float sizeMultiplier) {
        this.sizeMultiplier = sizeMultiplier;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.speed = sizeMultiplier;

        return simpleCompiledParticle.compileSender();
    }

}
