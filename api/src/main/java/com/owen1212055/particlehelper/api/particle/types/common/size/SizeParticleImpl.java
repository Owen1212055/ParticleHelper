package com.owen1212055.particlehelper.api.particle.types.common.size;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.particle.types.SizeableParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;

public class SizeParticleImpl extends AbstractSingleParticle implements SizeableParticle {

    private float size;

    public SizeParticleImpl(ParticleType<?, ?> particleType) {
        super(particleType);
    }

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
