package com.owen1212055.particlehelper.api.particle.types.itemcrack;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.MaterialParticle;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.VelocityParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Material;

public class SingleItemCrackParticle extends VelocityParticle implements MaterialParticle {

    private Material data;

    public SingleItemCrackParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public Material getMaterial() {
        return this.data;
    }

    @Override
    public void setMaterial(Material material) {
        this.data = material;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.xVelocity;
        simpleCompiledParticle.offsetY = this.yVelocity;
        simpleCompiledParticle.offsetZ = this.zVelocity;
        simpleCompiledParticle.speed = this.speed;
        simpleCompiledParticle.data = this.data;

        return simpleCompiledParticle.compileSender();
    }
}
