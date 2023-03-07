package com.owen1212055.particlehelper.api.particle.types.common.blockdata;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.particle.types.BlockDataParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

public class SingleBlockDataParticle extends AbstractSingleParticle<SingleBlockDataParticle> implements BlockDataParticle<SingleBlockDataParticle> {

    private BlockData blockData = Bukkit.createBlockData(Material.STONE);

    public SingleBlockDataParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public @NotNull BlockData blockData() {
        return this.blockData;
    }

    @NotNull
    @Override
    public SingleBlockDataParticle blockData(@NotNull BlockData data) {
        this.blockData = data;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle compiledParticle = new SimpleCompiledParticle(this);
        compiledParticle.data = blockData;

        return compiledParticle.compileSender();
    }

}
