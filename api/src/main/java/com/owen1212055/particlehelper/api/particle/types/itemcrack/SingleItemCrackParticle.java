package com.owen1212055.particlehelper.api.particle.types.itemcrack;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.ItemStackParticle;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.AbstractVelocityParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SingleItemCrackParticle extends AbstractVelocityParticle<SingleItemCrackParticle> implements ItemStackParticle<SingleItemCrackParticle> {

    private ItemStack data = new ItemStack(Material.APPLE);

    public SingleItemCrackParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public @NotNull ItemStack itemStack() {
        return this.data;
    }

    @NotNull
    @Override
    public SingleItemCrackParticle itemStack(@NotNull ItemStack material) {
        this.data = material;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.xVelocity;
        simpleCompiledParticle.offsetY = this.yVelocity;
        simpleCompiledParticle.offsetZ = this.zVelocity;
        simpleCompiledParticle.speed = this.speed;
        simpleCompiledParticle.data = this.data;

        return simpleCompiledParticle.compileSender();
    }
}
