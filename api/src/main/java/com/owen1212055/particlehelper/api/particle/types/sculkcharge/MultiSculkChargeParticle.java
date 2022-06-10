package com.owen1212055.particlehelper.api.particle.types.sculkcharge;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.RollableParticle;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.MultiSpeedModifiableParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;

public class MultiSculkChargeParticle extends MultiSpeedModifiableParticle implements RollableParticle {

    private float roll;

    public MultiSculkChargeParticle(ParticleType<?, ?> particleType) {
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
        simpleCompiledParticle.speed = this.speed;
        simpleCompiledParticle.data = roll;

        return simpleCompiledParticle.compileSender();
    }
}
