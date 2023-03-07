package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.MultiParticle;
import com.owen1212055.particlehelper.api.particle.Particle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.jetbrains.annotations.NotNull;

/**
 * The base implementation for a multi particle.
 *
 * Multi particles are always sent with a fixes amount, where there is an offset that represents the X/Y/Z.
 */
public abstract class AbstractMultiParticle<T extends Particle<T>> implements MultiParticle<T> {

    protected final ParticleType<?, ?> particleType;

    protected int count;
    protected float xOffset;
    protected float yOffset;
    protected float zOffset;

    protected boolean alwaysSend;

    public AbstractMultiParticle(ParticleType<?, ?> particleType) {
        this.particleType = particleType;
    }

    @Override
    public int count() {
        return this.count;
    }

    @SuppressWarnings("unchecked")
    @Override
    public @NotNull T count(int count) {
        this.count = count;
        return (T) this;
    }

    @Override
    public float xOffset() {
        return this.xOffset;
    }

    @SuppressWarnings("unchecked")
    @Override
    public @NotNull T xOffset(float offset) {
        this.xOffset = offset;
        return (T) this;
    }

    @Override
    public float yOffset() {
        return this.yOffset;
    }

    @SuppressWarnings("unchecked")
    @Override
    public @NotNull T yOffset(float offset) {
        this.yOffset = offset;
        return (T) this;
    }

    @Override
    public float zOffset() {
        return this.zOffset;
    }

    @SuppressWarnings("unchecked")
    @Override
    public @NotNull T zOffset(float zOffset) {
        this.zOffset = zOffset;
        return (T) this;
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
        return this.alwaysSend;
    }

    @Override
    public ParticleType<?, ?> getType() {
        return this.particleType;
    }
}
