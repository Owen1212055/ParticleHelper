package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a particle that is
 * able to have its size modified.
 */
public interface SizeableParticle<T extends Particle<T>> extends Particle<T> {

    float size();

    @Contract("_ -> this")
    @NotNull
    T size(float size);
}
