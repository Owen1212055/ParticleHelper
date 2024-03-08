package com.owen1212055.particlehelper.api.particle.types.itemcrack;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.jetbrains.annotations.*;

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
