package com.owen1212055.particlehelper.api.particle.types.common;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractMultiParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;

public class SimpleMultiParticle extends AbstractMultiParticle {

    public SimpleMultiParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public CompiledParticle compile() {
        return new SimpleCompiledParticle(this).compileSender();
    }
}
