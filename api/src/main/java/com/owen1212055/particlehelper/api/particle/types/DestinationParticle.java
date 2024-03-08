package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.*;
import org.jetbrains.annotations.*;

/**
 * Represents a particle that will start at the given position and move towards
 * its spawning location.
 */
public interface DestinationParticle<T extends Particle<T>> extends Particle<T> {

    float originX();

    @Contract("_ -> this")
    @NotNull
    T originX(float x);

    float originY();

    @Contract("_ -> this")
    @NotNull
    T originY(float y);

    float originZ();

    @Contract("_ -> this")
    @NotNull
    T originZ(float z);

}
