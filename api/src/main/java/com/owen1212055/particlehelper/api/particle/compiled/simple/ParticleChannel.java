package com.owen1212055.particlehelper.api.particle.compiled.simple;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.ApiStatus;

import java.util.function.BiConsumer;

/**
 * Internally used for sending simple compiled particles without using
 * the bukkit api.
 */
@ApiStatus.Internal
public interface ParticleChannel {

    BiConsumer<Player, Location> getSender(SimpleCompiledParticle particle);
}