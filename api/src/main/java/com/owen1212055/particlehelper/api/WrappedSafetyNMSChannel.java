package com.owen1212055.particlehelper.api;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.ParticleChannel;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;

import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

class WrappedSafetyNMSChannel implements ParticleChannel {

    private final Logger logger;
    private ParticleChannel particleChannel;
    private boolean isBukkit = false;

    WrappedSafetyNMSChannel(Logger logger) {
        this.logger = logger;
        try {
            this.particleChannel = new NMSChannel();
        } catch (Throwable e) {
            bukkitBind(e);
        }
    }

    @Override
    public CompiledParticle getSingleSender(SimpleCompiledParticle particle) {
        return this.runSafe(particleChannel -> particleChannel.getSingleSender(particle));
    }

    @Override
    public CompiledParticle getGroupedSender(CompiledParticle... particles) {
        return this.runSafe(particleChannel -> particleChannel.getGroupedSender(particles));
    }

    private <T> T runSafe(Function<ParticleChannel, T> consumer) {
        try {
            return consumer.apply(this.particleChannel);
        } catch (Throwable e) {
            if (!isBukkit) {
                return consumer.apply(this.bukkitBind(e));
            } else {
                throw new RuntimeException(e);
            }
        }
    }

    // Attempt to bind if this is shaded into a jar for example
    private ParticleChannel bukkitBind(Throwable e) {
        logger.log(Level.WARNING, "Failed to fetch certain NMS classes! Using bukkit API (less performant & ignores forceSend).", e);
        isBukkit = true;
        this.particleChannel = new BukkitChannel();

        return this.particleChannel;
    }
}