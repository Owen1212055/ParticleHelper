package com.owen1212055.particlehelper.api.particle.types.entityeffect;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.jetbrains.annotations.*;

public class MultiEntityEffectParticle extends AbstractMultiParticle<MultiEntityEffectParticle> {

    private float colorMultiplier;

    public MultiEntityEffectParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    public float colorMultiplier() {
        return colorMultiplier;
    }

    public MultiEntityEffectParticle colorMultiplier(float colorMultiplier) {
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
