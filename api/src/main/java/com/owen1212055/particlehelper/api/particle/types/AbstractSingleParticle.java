package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.*;
import com.owen1212055.particlehelper.api.type.*;

public abstract class AbstractSingleParticle implements Particle {

    protected final ParticleType<?, ?> particleType;

    protected boolean alwaysSend;

    public AbstractSingleParticle(ParticleType<?, ?> particleType) {
        this.particleType = particleType;
    }

    @Override
    public void forceSend(boolean forceSend) {
        this.alwaysSend = forceSend;
    }

    @Override
    public boolean shouldForceSend() {
        return alwaysSend;
    }

    @Override
    public ParticleType<?, ?> getType() {
        return this.particleType;
    }
}
