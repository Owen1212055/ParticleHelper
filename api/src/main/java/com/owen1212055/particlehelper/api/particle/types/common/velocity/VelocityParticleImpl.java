package com.owen1212055.particlehelper.api.particle.types.common.velocity;

import com.owen1212055.particlehelper.api.particle.Particle;
import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.particle.types.velocity.VelocityParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.jetbrains.annotations.NotNull;

public class VelocityParticleImpl<T extends Particle<T>> extends AbstractSingleParticle<T> implements VelocityParticle<T> {

    protected float xVelocity;
    protected float yVelocity;
    protected float zVelocity;
    protected float speed;

    public VelocityParticleImpl(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public float velocityX() {
        return this.xVelocity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public @NotNull T velocityX(float xVelocity) {
        this.xVelocity = xVelocity;
        return (T) this;
    }

    @Override
    public float velocityY() {
        return this.yVelocity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public @NotNull T velocityY(float yVelocity) {
        this.yVelocity = yVelocity;
        return (T) this;
    }

    @Override
    public float velocityZ() {
        return this.zVelocity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public @NotNull T velocityZ(float zVelocity) {
        this.zVelocity = zVelocity;
        return (T) this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.xVelocity;
        simpleCompiledParticle.offsetY = this.yVelocity;
        simpleCompiledParticle.offsetZ = this.zVelocity;
        simpleCompiledParticle.speed = 1; // Keep speed constant

        return simpleCompiledParticle.compileSender();
    }

}
