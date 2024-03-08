package com.owen1212055.particlehelper.api.particle.types.common.destination;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.jetbrains.annotations.*;

public class SingleDestinationParticle extends AbstractSingleParticle<SingleDestinationParticle> implements DestinationParticle<SingleDestinationParticle> {

    protected float xFrom;
    protected float yFrom;
    protected float zFrom;

    public SingleDestinationParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public float originX() {
        return this.xFrom;
    }

    @Override
    public @NotNull SingleDestinationParticle originX(float x) {
        this.xFrom = x;
        return this;
    }

    @Override
    public float originY() {
        return this.yFrom;
    }

    @Override
    public @NotNull SingleDestinationParticle originY(float y) {
        this.yFrom = y;
        return this;
    }

    @Override
    public float originZ() {
        return this.zFrom;
    }

    @Override
    public @NotNull SingleDestinationParticle originZ(float z) {
        this.zFrom = z;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.xFrom;
        simpleCompiledParticle.offsetY = this.yFrom;
        simpleCompiledParticle.offsetZ = this.zFrom;
        simpleCompiledParticle.speed = 1; // Keep speed constant

        return simpleCompiledParticle.compileSender();
    }

}
