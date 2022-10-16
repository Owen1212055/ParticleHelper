package com.owen1212055.particlehelper.api.particle.types.common.velocity;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractMultiParticle;
import com.owen1212055.particlehelper.api.particle.types.SpeedModifiableParticle;
import com.owen1212055.particlehelper.api.particle.types.velocity.YComponentVelocityParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;

/**
 * These particles have the unique property of being able to customize how
 * much "velocity" the y component has.
 * This allows you to customize how high the particle will float to.
 * Very high numbers will cause it float high, and very low values (negatives) will eventually
 * cause it to stand in place and not float.
 */
public class SingleRisingParticle extends AbstractMultiParticle implements YComponentVelocityParticle {

    private float yVelocity;
    private float speed;

    public SingleRisingParticle(ParticleType<?, ?> particleType) {
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
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetY = this.yVelocity;
        simpleCompiledParticle.speed = 1;

        return simpleCompiledParticle.compileSender();
    }
}
