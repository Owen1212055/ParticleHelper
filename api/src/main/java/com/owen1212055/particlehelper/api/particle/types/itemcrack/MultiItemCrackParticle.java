package com.owen1212055.particlehelper.api.particle.types.itemcrack;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.ItemStackParticle;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.MultiSpeedModifiableParticleImpl;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class MultiItemCrackParticle extends MultiSpeedModifiableParticleImpl<MultiItemCrackParticle> implements ItemStackParticle<MultiItemCrackParticle> {

    private ItemStack data = new ItemStack(Material.APPLE);

    public MultiItemCrackParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public @NotNull ItemStack itemStack() {
        return this.data;
    }

    @NotNull
    @Override
    public MultiItemCrackParticle itemStack(@NotNull ItemStack material) {
        this.data = material;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.speed = this.speed;
        simpleCompiledParticle.data = this.data;

        return simpleCompiledParticle.compileSender();
    }
}
