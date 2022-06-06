package com.owen1212055.particlehelper.api.particle.types.common;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;

public class SimpleSingleParticle extends AbstractSingleParticle {

    public SimpleSingleParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public CompiledParticle compile() {
        return new SimpleCompiledParticle(this).compileSender();
    }
}
