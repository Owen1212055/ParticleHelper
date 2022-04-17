package com.owen1212055.particlehelper.api.type;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.*;

public interface ParticleType<S extends Particle, M extends Particle> extends Keyed {

    S single();

    M multi();

}
