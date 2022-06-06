package com.owen1212055.particlehelper.api.particle.types.common.reducedmomentum;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.particle.types.velocity.YModifiableParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;

public class ReducedMomentumParticle extends AbstractSingleParticle implements YModifiableParticle {

    protected boolean reducedMomentum;
    protected float yVelocity;

    public ReducedMomentumParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    public boolean hasReducedHorizontalMomentum() {
        return this.reducedMomentum;
    }

    public void setHasReducedHorizontalMomentum(boolean reduced) {
        this.reducedMomentum = reduced;
    }

    @Override
    public float getVelocityY() {
        return this.yVelocity;
    }

    @Override
    public void setVelocityY(float yVelocity) {
        this.yVelocity = yVelocity;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.reducedMomentum ? 0 : 1;
        simpleCompiledParticle.offsetY = this.yVelocity;
        simpleCompiledParticle.speed = 1; // Keep speed constant

        return simpleCompiledParticle.compileSender();
    }
}
