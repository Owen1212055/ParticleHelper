package com.owen1212055.particlehelper.api.type;

import com.owen1212055.particlehelper.api.particle.Particle;
import com.owen1212055.particlehelper.api.particle.*;
import org.bukkit.*;
import org.jetbrains.annotations.*;

import java.util.function.*;

public interface StaticParticle extends ParticleType<Particle<?>, MultiParticle<?>> {

    record ApiParticle(NamespacedKey key,
                       Function<ApiParticle, Particle<?>> singleBuilder,
                       Function<ApiParticle, MultiParticle<?>> multibuilder) implements StaticParticle {

        @Override
        public @NotNull NamespacedKey getKey() {
            return this.key;
        }

        @Override
        public @NotNull Particle<?> single() {
            return this.singleBuilder.apply(this);
        }

        @Override
        public @NotNull MultiParticle<?> multi() {
            return this.multibuilder.apply(this);
        }
    }
}
