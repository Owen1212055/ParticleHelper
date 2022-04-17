package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.*;
import org.bukkit.block.data.*;

public interface BlockDataParticle extends Particle {

    BlockData getBlockData();

    void setBlockData(BlockData data);
}
