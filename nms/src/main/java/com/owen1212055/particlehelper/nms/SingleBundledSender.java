package com.owen1212055.particlehelper.nms;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import net.minecraft.core.particles.*;
import net.minecraft.network.protocol.game.*;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_20_R3.*;

public class SingleBundledSender extends ParticleSender implements CompiledParticle {

    private final CompiledParticle simpleCompiledParticles;

    public SingleBundledSender(CompiledParticle simpleCompiledParticles) {
        this.simpleCompiledParticles = simpleCompiledParticles;
    }

    @Override
    protected ClientboundLevelParticlesPacket createPacket(Location location) {
        SimpleCompiledParticle compiled = (SimpleCompiledParticle) simpleCompiledParticles;

        NamespacedKey key = compiled.particle.getKey();
        Particle bukkitParticle = ParticleHelper.BUKKIT_MAP.get(key);
        if (bukkitParticle == null) {
            throw new UnsupportedOperationException("Could not find particle %s, please report this.".formatted(key.toString()));
        }

        ParticleOptions nmsParticle = CraftParticle.createParticleParam(bukkitParticle, compiled.data);


        return ParticleHelper.createPacket(nmsParticle, location, compiled);
    }
}
