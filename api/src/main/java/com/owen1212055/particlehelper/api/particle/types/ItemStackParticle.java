package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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
