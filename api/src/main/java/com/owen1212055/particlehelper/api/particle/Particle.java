package com.owen1212055.particlehelper.api.particle;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.jetbrains.annotations.*;

public interface Particle<T extends Particle<T>> extends CompiledParticle {

    /**
     * Gets the ParticleType this particle represents.
     * @return type
     */
    ParticleType<?, ?> getType();

    /**
     * Is this particle forcibly shown on the client?
     * @return is forcibly shown
     */
    boolean forceShow();

    /**
     * Represents if a particle should be forcibly shown
     * on the client. This ignores all settings the client
     * might have.
     * @param forceShow should be forcibly shown
     */
    @Contract("_ -> this")
    @NotNull
    T forceShow(boolean forceShow);

    /**
     * Compiles an immutable version of this
     * particle which can be sent to players.
     * <p>
     * This is a way to send the same particle to many players
     * in an optimized manner, where certain logic like sharing
     * the packet can be done.
     *
     * @return compiled immutable particle
     */
    @NotNull
    CompiledParticle compile();

    /**
     * Quickly sends the particle to the player, a shortcut
     * which throws away a compiled particle.
     * @param player player
     * @param location location
     */
    @Override
    default void send(Player player, Location location) {
        compile().send(player, location);
    }

    @Override
    default void sendToTrackingPlayers(org.bukkit.Location location) {
        compile().sendToTrackingPlayers(location);
    }
}
