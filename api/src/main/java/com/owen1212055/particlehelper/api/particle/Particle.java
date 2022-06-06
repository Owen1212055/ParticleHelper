package com.owen1212055.particlehelper.api.particle;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Location;
import org.bukkit.entity.Player;

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
