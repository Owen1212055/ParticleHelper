package com.owen1212055.particlehelper.api.particle.types.common.size;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.jetbrains.annotations.*;

public class SingleSizeParticle extends AbstractSingleParticle<SingleSizeParticle> implements SizeableParticle<SingleSizeParticle> {

    private float size;

    public SingleSizeParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public float size() {
        return this.size;
    }

    @NotNull
    @Override
    public SingleSizeParticle size(float size) {
        this.size = size;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.size;
        simpleCompiledParticle.speed = 1; // Keep size constant

        return simpleCompiledParticle.compileSender();
    }

}
