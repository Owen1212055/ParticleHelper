package com.owen1212055.particlehelper.api.particle.types.common.velocity;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractMultiParticle;
import com.owen1212055.particlehelper.api.particle.types.SpeedModifiableParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;

public class MultiSpeedModifiableParticle extends AbstractMultiParticle implements SpeedModifiableParticle {

    protected float speed;

    public MultiSpeedModifiableParticle(ParticleType<?, ?> particleType) {
        super(particleType);
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
        simpleCompiledParticle.speed = this.speed;

        return simpleCompiledParticle;
    }
}
