package com.owen1212055.particlehelper.api.particle.types.common.velocity;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractMultiParticle;
import com.owen1212055.particlehelper.api.particle.types.SpeedModifiableParticle;
import com.owen1212055.particlehelper.api.particle.types.velocity.YModifiableParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;

public class YVelocityParticle extends AbstractMultiParticle implements YModifiableParticle, SpeedModifiableParticle {

    private float yVelocity;
    private float speed;

    public YVelocityParticle(ParticleType<?, ?> particleType) {
        super(particleType);
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
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetY = this.yVelocity;
        simpleCompiledParticle.speed = this.speed;

        return simpleCompiledParticle;
    }
}
