package com.owen1212055.particlehelper.api.type;

import com.owen1212055.particlehelper.api.particle.types.common.velocity.MultiSpeedModifiableParticle;
import com.owen1212055.particlehelper.api.particle.types.velocity.VelocityModifiableParticle;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

interface MoveableParticle extends ParticleType<VelocityModifiableParticle, MultiSpeedModifiableParticle> {

    record ApiParticle(NamespacedKey key,
                       Function<ApiParticle, VelocityModifiableParticle> singleBuilder,
                       Function<ApiParticle, MultiSpeedModifiableParticle> multibuilder) implements MoveableParticle {

        @Override
        public @NotNull NamespacedKey getKey() {
            return this.key;
        }

        @Override
        public VelocityModifiableParticle single() {
            return this.singleBuilder.apply(this);
        }

        @Override
        public MultiSpeedModifiableParticle multi() {
            return this.multibuilder.apply(this);
        }
    }
}
