package com.owen1212055.particlehelper.api.particle.types.common.destination;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;

public class DestinationParticleImpl extends AbstractSingleParticle implements DestinationParticle {

    protected float xFrom;
    protected float yFrom;
    protected float zFrom;
    protected float speed;

    public DestinationParticleImpl(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public float getOriginX() {
        return this.xFrom;
    }

    @Override
    public void setOriginX(float x) {
        this.xFrom = x;
    }

    @Override
    public float getOriginY() {
        return this.yFrom;
    }

    @Override
    public void setOriginY(float y) {
        this.yFrom = y;
    }

    @Override
    public float getOriginZ() {
        return this.zFrom;
    }

    @Override
    public void setOriginZ(float z) {
        this.zFrom = z;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.xFrom;
        simpleCompiledParticle.offsetY = this.yFrom;
        simpleCompiledParticle.offsetZ = this.zFrom;
        simpleCompiledParticle.speed = 1; // Keep speed constant

        return simpleCompiledParticle.compileSender();
    }

}
