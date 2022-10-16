package com.owen1212055.particlehelper.api.type;

import com.owen1212055.particlehelper.api.particle.MultiParticle;
import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public interface StaticParticle extends ParticleType<Particle, MultiParticle> {

    record ApiParticle(NamespacedKey key,
                       Function<ApiParticle, Particle> singleBuilder,
                       Function<ApiParticle, MultiParticle> multibuilder) implements StaticParticle {

        @Override
        public @NotNull NamespacedKey getKey() {
            return this.key;
        }

        @Override
        public @NotNull Particle single() {
            return this.singleBuilder.apply(this);
        }

        @Override
        public @NotNull MultiParticle multi() {
            return this.multibuilder.apply(this);
        }
    }
}
