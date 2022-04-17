package com.owen1212055.particlehelper.api.particle;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.*;
import org.bukkit.entity.*;

public interface Particle extends CompiledParticle {

    ParticleType<?, ?> getType();

    boolean shouldForceSend();

    void forceSend(boolean forceSend);

    CompiledParticle compile();

    @Override
    default void send(Player player, Location location) {
        compile().send(player, location);
    }
}
