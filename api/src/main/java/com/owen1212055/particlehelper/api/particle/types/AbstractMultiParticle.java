package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.MultiParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;

public abstract class AbstractMultiParticle implements MultiParticle {

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
    public int getCount() {
        return this.count;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public float getXOffset() {
        return this.xOffset;
    }

    @Override
    public void setXOffset(float offset) {
        this.xOffset = offset;
    }

    @Override
    public float getYOffset() {
        return this.yOffset;
    }

    @Override
    public void setYOffset(float offset) {
        this.yOffset = offset;
    }

    @Override
    public float getZOffset() {
        return this.zOffset;
    }

    @Override
    public void setZOffset(float zOffset) {
        this.zOffset = zOffset;
    }

    @Override
    public void forceSend(boolean forceSend) {
        this.alwaysSend = forceSend;
    }

    @Override
    public boolean shouldForceSend() {
        return this.alwaysSend;
    }

    @Override
    public ParticleType<?, ?> getType() {
        return this.particleType;
    }
}
