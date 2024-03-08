package com.owen1212055.particlehelper.api.particle.types.dust;

import com.owen1212055.particlehelper.api.particle.Particle;
import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.*;
import org.jetbrains.annotations.*;

public abstract class MultiDustParticleImpl<T extends Particle<T>> extends MultiSpeedModifiableParticleImpl<T> implements DustParticle<T> {

    protected Color color = Color.RED;
    protected float size;

    public MultiDustParticleImpl(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public Color color() {
        return this.color;
    }

    @SuppressWarnings("unchecked")
    @NotNull
    @Override
    public T color(Color color) {
        this.color = color;
        return (T) this;
    }

    @Override
    public float size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    @NotNull
    @Override
    public T size(float size) {
        this.size = size;
        return (T) this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.speed = this.speed;
        simpleCompiledParticle.data = new org.bukkit.Particle.DustOptions(color, size);

        return simpleCompiledParticle.compileSender();
    }
}
