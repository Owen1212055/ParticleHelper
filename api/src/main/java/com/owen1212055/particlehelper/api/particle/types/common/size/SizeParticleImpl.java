package com.owen1212055.particlehelper.api.particle.types.common.size;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;

public class SizeParticleImpl extends AbstractSingleParticle implements SizeableParticle {

    public SizeParticleImpl(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    private float size;

    @Override
    public float getSize() {
        return this.size;
    }

    @Override
    public void setSize(float size) {
        this.size = size;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.size;
        simpleCompiledParticle.speed = 1; // Keep size constant

        return simpleCompiledParticle.compileSender();
    }

}
