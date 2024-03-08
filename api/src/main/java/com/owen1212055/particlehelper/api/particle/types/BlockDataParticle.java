package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.*;
import org.bukkit.block.data.*;
import org.jetbrains.annotations.*;

/**
 * Represents a particle which can have the blockdata it represents
 * modified.
 */
public interface BlockDataParticle<T extends Particle<T>> extends Particle<T> {

    @NotNull
    BlockData blockData();

    @Contract("_ -> this")
    @NotNull
    T blockData(@NotNull BlockData data);
}
