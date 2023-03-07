package com.owen1212055.particlehelper.api.particle.types.common.size;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.particle.types.SizeableParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.jetbrains.annotations.NotNull;

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
