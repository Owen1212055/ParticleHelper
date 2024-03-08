package com.owen1212055.particlehelper.api.particle.compiled;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.jetbrains.annotations.*;

/**
 * A compiled particle is responsible for sending a
 * particle to a player at a given location.
 *
 * The idea of compiling it is to reduce the need to
 * calculate the minecraft values for each time you want to send.
 * You can simply store this compiled particle and there will be
 * no overhead of recalculating values.
 */
@ApiStatus.NonExtendable
public interface CompiledParticle {

    void send(Player player, Location location);

    void sendToTrackingPlayers(Location location);
}
