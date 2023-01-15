package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a particle which can have the material it represents
 * modified.
 */
public interface ItemStackParticle extends Particle {

    @NotNull
    ItemStack getItemStack();

    void setItemStack(@NotNull ItemStack material);
}
