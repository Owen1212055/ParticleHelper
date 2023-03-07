package com.owen1212055.particlehelper.api.particle.types.sculkcharge;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.RollableParticle;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.MultiSpeedModifiableParticleImpl;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.jetbrains.annotations.NotNull;

public class MultiSculkChargeParticle extends MultiSpeedModifiableParticleImpl<MultiSculkChargeParticle> implements RollableParticle<MultiSculkChargeParticle> {

    private float roll;

    public MultiSculkChargeParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public float roll() {
        return this.roll;
    }

    @Override
    public @NotNull MultiSculkChargeParticle roll(float roll) {
        this.roll = roll;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.speed = this.speed;
        simpleCompiledParticle.data = roll;

        return simpleCompiledParticle.compileSender();
    }
}
