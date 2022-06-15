package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a particle which can have the material it represents
 * modified.
 */
public interface MaterialParticle extends Particle {

    @NotNull
    Material getMaterial();

    void setMaterial(@NotNull Material material);
}
