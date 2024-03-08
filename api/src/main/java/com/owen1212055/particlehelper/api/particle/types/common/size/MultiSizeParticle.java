package com.owen1212055.particlehelper.api.particle.types.common.size;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.jetbrains.annotations.*;

public class MultiSizeParticle extends AbstractMultiParticle<MultiSizeParticle> {

    private float sizeMultiplier;

    public MultiSizeParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    public float sizeMultiplier() {
        return this.sizeMultiplier;
    }

    @Contract("_ -> this")
    @NotNull
    public MultiSizeParticle sizeMultiplier(float sizeMultiplier) {
        this.sizeMultiplier = sizeMultiplier;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.speed = sizeMultiplier;

        return simpleCompiledParticle.compileSender();
    }

}
