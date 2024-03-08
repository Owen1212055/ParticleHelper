package com.owen1212055.particlehelper.api.particle.types.sculkcharge;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.*;
import com.owen1212055.particlehelper.api.type.*;
import org.jetbrains.annotations.*;

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
