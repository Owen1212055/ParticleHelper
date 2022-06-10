package com.owen1212055.particlehelper.api.particle.types.sculkcharge;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.RollableParticle;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.VelocityParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;

public class SingleSculkChargeParticle extends VelocityParticle implements RollableParticle {

    private float roll;

    public SingleSculkChargeParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public float getRoll() {
        return this.roll;
    }

    @Override
    public void setRoll(float roll) {
        this.roll = roll;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.xVelocity;
        simpleCompiledParticle.offsetY = this.yVelocity;
        simpleCompiledParticle.offsetZ = this.zVelocity;
        simpleCompiledParticle.speed = this.speed;
        simpleCompiledParticle.data = roll;

        return simpleCompiledParticle.compileSender();
    }
}
