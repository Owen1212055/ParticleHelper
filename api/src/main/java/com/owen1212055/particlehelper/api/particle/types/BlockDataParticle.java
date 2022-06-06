package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.block.data.BlockData;

public interface BlockDataParticle extends Particle {

    BlockData getBlockData();

    void setBlockData(BlockData data);
}
