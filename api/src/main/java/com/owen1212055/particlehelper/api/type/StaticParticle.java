package com.owen1212055.particlehelper.api.type;

import com.owen1212055.particlehelper.api.particle.*;
import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.*;
import org.jetbrains.annotations.*;

import java.util.function.*;

interface StaticParticle extends ParticleType<Particle, MultiParticle> {

    record ApiParticle(NamespacedKey key,
                       Function<ApiParticle, Particle> singleBuilder,
                       Function<ApiParticle, MultiParticle> multibuilder) implements StaticParticle {

        @Override
        public @NotNull NamespacedKey getKey() {
            return this.key;
        }

        @Override
        public Particle single() {
            return this.singleBuilder.apply(this);
        }

        @Override
        public MultiParticle multi() {
            return this.multibuilder.apply(this);
        }
    }
}
