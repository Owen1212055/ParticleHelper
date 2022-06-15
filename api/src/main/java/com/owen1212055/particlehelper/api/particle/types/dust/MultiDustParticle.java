package com.owen1212055.particlehelper.api.particle.types.dust;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.MultiSpeedModifiableParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Color;
import org.bukkit.Particle;

public class MultiDustParticle extends MultiSpeedModifiableParticle implements DustParticle {

    protected Color color = Color.RED;
    protected float size;

    public MultiDustParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public float getSize() {
        return this.size;
    }

    @Override
    public void setSize(float size) {
        this.size = size;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.speed = this.speed;
        simpleCompiledParticle.data = new Particle.DustOptions(color, size);

        return simpleCompiledParticle.compileSender();
    }
}
