package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.Color;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a particle which can have its color modified.
 */
public interface ColorableParticle<T extends Particle<T>> extends Particle<T> {

    Color color();

    @Contract("_ -> this")
    @NotNull T color(Color color);
}
