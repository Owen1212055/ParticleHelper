package com.owen1212055.particlehelper.api.particle.types.common.blockdata;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.*;
import org.bukkit.block.data.*;
import org.jetbrains.annotations.*;

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
