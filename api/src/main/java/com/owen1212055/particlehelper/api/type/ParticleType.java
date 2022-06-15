package com.owen1212055.particlehelper.api.type;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.Keyed;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface ParticleType<S extends Particle, M extends Particle> extends Keyed {

    @NotNull
    @Contract("-> new")
    S single();

    @NotNull
    @Contract("-> new")
    M multi();

}
