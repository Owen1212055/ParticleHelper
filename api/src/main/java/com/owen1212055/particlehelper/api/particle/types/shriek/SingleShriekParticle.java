package com.owen1212055.particlehelper.api.particle.types.shriek;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.jetbrains.annotations.*;

public class SingleShriekParticle extends AbstractSingleParticle<SingleShriekParticle> implements DelayableParticle<SingleShriekParticle> {

    private int delay;

    public SingleShriekParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public int delay() {
        return this.delay;
    }

    @Override
    public @NotNull SingleShriekParticle delay(int delay) {
        this.delay = delay;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.data = this.delay;
        simpleCompiledParticle.speed = 1; // Keep speed constant

        return simpleCompiledParticle.compileSender();
    }
}
