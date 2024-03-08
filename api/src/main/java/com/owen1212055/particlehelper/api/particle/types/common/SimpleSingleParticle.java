package com.owen1212055.particlehelper.api.particle.types.common;

import com.owen1212055.particlehelper.api.particle.*;
import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.jetbrains.annotations.*;

public class SimpleSingleParticle<T extends Particle<T>> extends AbstractSingleParticle<T> {

    public SimpleSingleParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public @NotNull CompiledParticle compile() {
        return new SimpleCompiledParticle(this).compileSender();
    }
}
