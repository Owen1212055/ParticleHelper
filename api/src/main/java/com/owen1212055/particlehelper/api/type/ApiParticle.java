package com.owen1212055.particlehelper.api.type;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

record ApiParticle<S extends Particle, M extends Particle>(NamespacedKey key,
                                                           Function<ParticleType<S, M>, S> singleBuilder,
                                                           Function<ParticleType<S, M>, M> multibuilder) implements ParticleType<S, M> {

    @Override
    public @NotNull NamespacedKey getKey() {
        return key;
    }


    @Override
    public S single() {
        return singleBuilder.apply(this);
    }

    @Override
    public M multi() {
        return multibuilder.apply(this);
    }
}
