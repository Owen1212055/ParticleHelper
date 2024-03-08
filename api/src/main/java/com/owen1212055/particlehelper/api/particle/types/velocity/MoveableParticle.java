package com.owen1212055.particlehelper.api.particle.types.velocity;

import com.owen1212055.particlehelper.api.particle.types.common.velocity.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.*;
import org.jetbrains.annotations.*;

import java.util.function.*;

public interface MoveableParticle extends ParticleType<SimpleVelocityParticle, MultiSpeedModifiableParticle> {

    record ApiParticle(NamespacedKey key,
                       Function<ApiParticle, SimpleVelocityParticle> singleBuilder,
                       Function<ApiParticle, MultiSpeedModifiableParticle> multibuilder) implements MoveableParticle {

        @Override
        public @NotNull NamespacedKey getKey() {
            return this.key;
        }

        @Override
        public @NotNull SimpleVelocityParticle single() {
            return this.singleBuilder.apply(this);
        }

        @Override
        public @NotNull MultiSpeedModifiableParticle multi() {
            return this.multibuilder.apply(this);
        }
    }
}
