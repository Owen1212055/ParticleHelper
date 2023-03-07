package com.owen1212055.particlehelper.api.type;

import com.owen1212055.particlehelper.api.particle.types.common.velocity.MultiSpeedModifiableParticleImpl;
import com.owen1212055.particlehelper.api.particle.types.velocity.VelocityParticle;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public interface MoveableParticle extends ParticleType<VelocityParticle<?>, MultiSpeedModifiableParticleImpl<?>> {

    record ApiParticle(NamespacedKey key,
                       Function<ApiParticle, VelocityParticle<?>> singleBuilder,
                       Function<ApiParticle, MultiSpeedModifiableParticleImpl<?>> multibuilder) implements MoveableParticle {

        @Override
        public @NotNull NamespacedKey getKey() {
            return this.key;
        }

        @Override
        public @NotNull VelocityParticle<?> single() {
            return this.singleBuilder.apply(this);
        }

        @Override
        public @NotNull MultiSpeedModifiableParticleImpl<?> multi() {
            return this.multibuilder.apply(this);
        }
    }
}
