package com.owen1212055.particlehelper.api.particle.types.common.velocity;

import com.owen1212055.particlehelper.api.particle.*;
import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.jetbrains.annotations.*;

public abstract class MultiSpeedModifiableParticleImpl<T extends Particle<T>> extends AbstractMultiParticle<T> implements SpeedModifiableParticle<T> {

    protected float speed;

    public MultiSpeedModifiableParticleImpl(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public float speed() {
        return this.speed;
    }

    @SuppressWarnings("unchecked")
    @Override
    public @NotNull T speed(float speed) {
        this.speed = speed;
        return (T) this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.speed = this.speed;

        return simpleCompiledParticle.compileSender();
    }
}
