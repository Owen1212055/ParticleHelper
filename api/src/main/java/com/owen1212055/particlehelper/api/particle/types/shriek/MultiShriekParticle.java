package com.owen1212055.particlehelper.api.particle.types.shriek;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.jetbrains.annotations.*;

public class MultiShriekParticle extends AbstractMultiParticle<MultiShriekParticle> implements DelayableParticle<MultiShriekParticle> {

    private int delay;

    public MultiShriekParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public int delay() {
        return this.delay;
    }

    @Override
    public @NotNull MultiShriekParticle delay(int delay) {
        this.delay = delay;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.data = delay;

        return simpleCompiledParticle.compileSender();
    }
}
