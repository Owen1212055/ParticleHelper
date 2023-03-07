package com.owen1212055.particlehelper.api.particle.types.note;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractMultiParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.jetbrains.annotations.NotNull;

public class MultiNoteParticle extends AbstractMultiParticle<MultiNoteParticle> {

    private float colorMultiplier;

    public MultiNoteParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    public float colorMultiplier() {
        return this.colorMultiplier;
    }

    public MultiNoteParticle colorMultiplier(float colorMultiplier) {
        this.colorMultiplier = colorMultiplier;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.speed = colorMultiplier;

        return simpleCompiledParticle.compileSender();
    }

}
