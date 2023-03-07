package com.owen1212055.particlehelper.api.particle.types.velocity;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a particle which can have its entire
 * velocity customized.
 */
public interface VelocityParticle<T extends Particle<T>> extends Particle<T>, YComponentVelocityParticle<T> {

    float velocityX();

    @Contract("_ -> this")
    @NotNull T velocityX(float xVelocity);

    @Override
    float velocityY();

    @Override
    @NotNull T velocityY(float yVelocity);

    float velocityZ();

    @Contract("_ -> this")
    @NotNull T velocityZ(float zVelocity);

}
