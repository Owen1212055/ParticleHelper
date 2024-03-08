package com.owen1212055.particlehelper.api.particle.types.common;

import com.owen1212055.particlehelper.api.particle.*;
import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.jetbrains.annotations.*;

public class SimpleMultiParticle<T extends Particle<T>> extends AbstractMultiParticle<T> {

    public SimpleMultiParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public @NotNull CompiledParticle compile() {
        return new SimpleCompiledParticle(this).compileSender();
    }
}
