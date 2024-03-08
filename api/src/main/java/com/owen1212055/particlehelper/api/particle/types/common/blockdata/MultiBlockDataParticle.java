package com.owen1212055.particlehelper.api.particle.types.common.blockdata;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.*;
import org.bukkit.block.data.*;
import org.jetbrains.annotations.*;

public class MultiBlockDataParticle extends AbstractMultiParticle<MultiBlockDataParticle> implements BlockDataParticle<MultiBlockDataParticle> {

    private BlockData blockData = Bukkit.createBlockData(Material.STONE);

    public MultiBlockDataParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public @NotNull BlockData blockData() {
        return this.blockData;
    }

    @NotNull
    @Override
    public MultiBlockDataParticle blockData(@NotNull BlockData blockData) {
        this.blockData = blockData;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.data = blockData;

        return simpleCompiledParticle.compileSender();
    }
}
