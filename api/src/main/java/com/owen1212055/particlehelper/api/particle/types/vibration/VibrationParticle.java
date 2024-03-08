package com.owen1212055.particlehelper.api.particle.types.vibration;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.*;
import org.jetbrains.annotations.*;

/**
 * Represents a particle with a vibration.
 */
public interface VibrationParticle<T extends Particle<T>> extends Particle<T> {

    @NotNull
    Vibration vibration();

    @Contract("_ -> this")
    @NotNull
    T vibration(@NotNull Vibration vibration);
}
