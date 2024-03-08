package com.owen1212055.particlehelper.api.particle.types.note;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.jetbrains.annotations.*;

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
