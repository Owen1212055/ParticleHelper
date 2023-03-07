package com.owen1212055.particlehelper.api.particle.types.common;

import com.owen1212055.particlehelper.api.particle.Particle;
import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractMultiParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.jetbrains.annotations.NotNull;

public class SimpleMultiParticle<T extends Particle<T>> extends AbstractMultiParticle<T> {

    public SimpleMultiParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public @NotNull CompiledParticle compile() {
        return new SimpleCompiledParticle(this).compileSender();
    }
}
