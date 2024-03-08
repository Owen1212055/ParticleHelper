package com.owen1212055.particlehelper.api.type;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.*;
import org.jetbrains.annotations.*;

import java.util.function.*;

record ApiParticle<S extends Particle<?>, M extends Particle<?>>(NamespacedKey key,
                                                           Function<ParticleType<S, M>, S> singleBuilder,
                                                           Function<ParticleType<S, M>, M> multibuilder) implements ParticleType<S, M> {

    @Override
    public @NotNull NamespacedKey getKey() {
        return key;
    }


    @Override
    public @NotNull S single() {
        return singleBuilder.apply(this);
    }

    @Override
    public @NotNull M multi() {
        return multibuilder.apply(this);
    }
}
