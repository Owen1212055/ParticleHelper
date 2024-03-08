package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.*;
import org.jetbrains.annotations.*;

/**
 * Represents a particle that has a delay (in ticks) before
 * starting to be rendered.
 */
public interface DelayableParticle<T extends Particle<T>> extends Particle<T> {

    int delay();

    @Contract("_ -> this")
    @NotNull T delay(int delay);
}
