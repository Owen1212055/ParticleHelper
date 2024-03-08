package com.owen1212055.particlehelper.api.particle;

import org.jetbrains.annotations.*;

public interface MultiParticle<T extends Particle<T>> extends Particle<T> {

    int count();

    @Contract("_ -> this")
    @NotNull
    T count(int count);

    float xOffset();

    @Contract("_ -> this")
    @NotNull
    T xOffset(float offset);

    float yOffset();

    @Contract("_ -> this")
    @NotNull
    T yOffset(float offset);

    float zOffset();

    @Contract("_ -> this")
    @NotNull
    T zOffset(float zOffset);

}
