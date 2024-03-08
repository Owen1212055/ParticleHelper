package com.owen1212055.particlehelper.api;


import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.*;
import org.jetbrains.annotations.*;

import java.util.logging.*;

public final class ParticleHelper {

    @ApiStatus.Internal
    public static final int MAGIC_TRACKING_RANGE = 512;
    private static final Logger LOGGER = Logger.getLogger("ParticleHelper");

    private static ParticleChannel ACTIVE_PARTICLE_CHANNEL = null;

    /**
     * Bundles compiled particle effects into one, allowing for multiple
     * particles to be sent within the same packet to players. Useful for
     * grouped particles.
     * <p>
     * May be changed in the future.
     *
     * @param particles compiled particles
     * @return channel
     */
    @ApiStatus.Experimental
    @NotNull
    public static CompiledParticle bundleParticles(CompiledParticle... particles) {
        return ACTIVE_PARTICLE_CHANNEL.getGroupedSender(particles);
    }

    /**
     * Attempts to setup the particle channel for sending
     * particles to players.
     * <p>
     * This will first try to use NMS, where if that fails the bukkit api
     * will be used instead.
     */
    @SuppressWarnings("unchecked")
    public static void bootstrapParticleChannel() {
        if (ACTIVE_PARTICLE_CHANNEL != null) {
            return;
        }

        ACTIVE_PARTICLE_CHANNEL = new WrappedSafetyNMSChannel(LOGGER);
    }

    @Nullable
    @ApiStatus.Internal
    public static ParticleChannel getActiveParticleChannel() {
        if (ACTIVE_PARTICLE_CHANNEL == null) {
            bootstrapParticleChannel();
        }

        return ACTIVE_PARTICLE_CHANNEL;
    }

    static org.bukkit.Particle toBukkit(ParticleType<?, ?> particle) {
        return Registry.PARTICLE_TYPE.get(particle.getKey());
    }

}
