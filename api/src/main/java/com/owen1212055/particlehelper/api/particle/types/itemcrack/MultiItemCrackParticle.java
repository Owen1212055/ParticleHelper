package com.owen1212055.particlehelper.api.particle.types.itemcrack;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.MaterialParticle;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.MultiSpeedModifiableParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class MultiItemCrackParticle extends MultiSpeedModifiableParticle implements MaterialParticle {

    private Material data = Material.APPLE;

    public MultiItemCrackParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public @NotNull Material getMaterial() {
        return this.data;
    }

    @Override
    public void setMaterial(@NotNull Material material) {
        this.data = material;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.speed = this.speed;
        simpleCompiledParticle.data = this.data;

        return simpleCompiledParticle.compileSender();
    }
}
