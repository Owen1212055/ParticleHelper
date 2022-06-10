package com.owen1212055.particlehelper.api.particle.types.shriek;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.particle.types.DelayableParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;

public class SingleShriekParticle extends AbstractSingleParticle implements DelayableParticle {

    private int delay;

    public SingleShriekParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public int getDelay() {
        return this.delay;
    }

    @Override
    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.data = this.delay;
        simpleCompiledParticle.speed = 1; // Keep speed constant

        return simpleCompiledParticle.compileSender();
    }
}
