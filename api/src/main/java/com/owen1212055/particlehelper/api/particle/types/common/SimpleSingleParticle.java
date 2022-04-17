package com.owen1212055.particlehelper.api.particle.types.common;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;

public class SimpleSingleParticle extends AbstractSingleParticle {

    public SimpleSingleParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public CompiledParticle compile() {
        return new SimpleCompiledParticle(this).compileSender();
    }
}
