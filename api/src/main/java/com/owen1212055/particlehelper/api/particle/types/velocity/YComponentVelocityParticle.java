package com.owen1212055.particlehelper.api.particle.types.velocity;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a particle which can only have
 * its y component modified in its velocity.
 */
public interface YComponentVelocityParticle<T extends Particle<T>> extends Particle<T> {

    float velocityY();

    @Contract("_ -> this")
    @NotNull T velocityY(float yVelocity);

}
