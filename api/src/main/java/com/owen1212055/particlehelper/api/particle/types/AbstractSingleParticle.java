package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractSingleParticle<T extends Particle<T>> implements Particle<T> {

    protected final ParticleType<?, ?> particleType;

    protected boolean alwaysSend;

    public AbstractSingleParticle(ParticleType<?, ?> particleType) {
        this.particleType = particleType;
    }

    @SuppressWarnings("unchecked")
    @NotNull
    @Override
    public T forceShow(boolean forceSend) {
        this.alwaysSend = forceSend;
        return (T) this;
    }

    @Override
    public boolean forceShow() {
        return alwaysSend;
    }

    @Override
    public ParticleType<?, ?> getType() {
        return this.particleType;
    }
}
