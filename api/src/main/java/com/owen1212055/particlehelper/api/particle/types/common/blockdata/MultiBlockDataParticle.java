package com.owen1212055.particlehelper.api.particle.types.common.blockdata;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractMultiParticle;
import com.owen1212055.particlehelper.api.particle.types.BlockDataParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

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
