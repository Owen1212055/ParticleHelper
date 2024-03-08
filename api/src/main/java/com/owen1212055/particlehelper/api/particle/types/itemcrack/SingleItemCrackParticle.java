package com.owen1212055.particlehelper.api.particle.types.itemcrack;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.jetbrains.annotations.*;

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
