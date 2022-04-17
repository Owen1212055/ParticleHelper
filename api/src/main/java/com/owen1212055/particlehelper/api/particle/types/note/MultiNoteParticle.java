package com.owen1212055.particlehelper.api.particle.types.note;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;

public class MultiNoteParticle extends AbstractMultiParticle {

    private float colorMultiplier;

    public MultiNoteParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    public float getColorMultiplier() {
        return this.colorMultiplier;
    }

    public void setColorMultplier(float colorMultiplier) {
        this.colorMultiplier = colorMultiplier;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.speed = colorMultiplier;

        return simpleCompiledParticle.compileSender();
    }

}
