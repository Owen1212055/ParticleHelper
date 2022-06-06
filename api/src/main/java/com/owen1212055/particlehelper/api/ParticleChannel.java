package com.owen1212055.particlehelper.api;

import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.function.BiConsumer;

public interface ParticleChannel {

    BiConsumer<Player, Location> getSender(SimpleCompiledParticle particle);
}
