package com.owen1212055.particlehelper.api.particle.compiled;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface CompiledParticle {

    void send(Player player, Location location);
}
