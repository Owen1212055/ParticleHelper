package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.*;
import org.bukkit.inventory.*;
import org.jetbrains.annotations.*;

/**
 * Represents a particle which can have the material it represents
 * modified.
 */
public interface ItemStackParticle<T extends Particle<T>> extends Particle<T> {

    @NotNull
    ItemStack itemStack();

    @Contract("_ -> this")
    @NotNull
    T itemStack(@NotNull ItemStack material);
}
