package com.owen1212055.particlehelper.api.particle.types.common.velocity;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.particle.types.velocity.VelocityModifiableParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;

public class VelocityParticle extends AbstractSingleParticle implements VelocityModifiableParticle {

    protected float xVelocity;
    protected float yVelocity;
    protected float zVelocity;
    protected float speed;

    public VelocityParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public float getVelocityX() {
        return this.xVelocity;
    }

    @Override
    public void setVelocityX(float xVelocity) {
        this.xVelocity = xVelocity;
    }

    @Override
    public float getVelocityY() {
        return this.yVelocity;
    }

    @Override
    public void setVelocityY(float yVelocity) {
        this.yVelocity = yVelocity;
    }

    @Override
    public float getVelocityZ() {
        return this.zVelocity;
    }

    @Override
    public void setVelocityZ(float zVelocity) {
        this.zVelocity = zVelocity;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.xVelocity;
        simpleCompiledParticle.offsetY = this.yVelocity;
        simpleCompiledParticle.offsetZ = this.zVelocity;
        simpleCompiledParticle.speed = 1; // Keep speed constant

        return simpleCompiledParticle.compileSender();
    }

}
