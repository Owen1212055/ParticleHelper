package com.owen1212055.particlehelper.api.particle.types.sculkcharge;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.RollableParticle;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.VelocityParticleImpl;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.jetbrains.annotations.NotNull;

public class SingleSculkChargeParticle extends VelocityParticleImpl<SingleSculkChargeParticle> implements RollableParticle<SingleSculkChargeParticle> {

    private float roll;

    public SingleSculkChargeParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public float roll() {
        return this.roll;
    }

    @Override
    public @NotNull SingleSculkChargeParticle roll(float roll) {
        this.roll = roll;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.xVelocity;
        simpleCompiledParticle.offsetY = this.yVelocity;
        simpleCompiledParticle.offsetZ = this.zVelocity;
        simpleCompiledParticle.speed = this.speed;
        simpleCompiledParticle.data = roll;

        return simpleCompiledParticle.compileSender();
    }
}
