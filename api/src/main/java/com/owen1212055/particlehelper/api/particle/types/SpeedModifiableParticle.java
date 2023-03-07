package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a particle that is able to have its
 * overall speed adjusted.
 */
public interface SpeedModifiableParticle<T extends Particle<T>> extends Particle<T> {

    float speed();

    @Contract("_ -> this")
    @NotNull
    T speed(float speed);

}
