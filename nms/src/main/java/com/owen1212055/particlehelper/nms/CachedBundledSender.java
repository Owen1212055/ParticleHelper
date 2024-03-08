package com.owen1212055.particlehelper.nms;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import net.minecraft.core.particles.*;
import net.minecraft.network.protocol.*;
import net.minecraft.network.protocol.game.*;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_20_R3.*;

import java.util.*;

public class CachedBundledSender extends ParticleSender implements CompiledParticle {

    private final CompiledParticle[] simpleCompiledParticles;

    public CachedBundledSender(CompiledParticle[] simpleCompiledParticles) {
        this.simpleCompiledParticles = simpleCompiledParticles;
    }

    @Override
    protected ClientboundBundlePacket createPacket(Location location) {
        List<Packet<ClientGamePacketListener>> particles = new ArrayList<>(simpleCompiledParticles.length);
        for (CompiledParticle simpleCompiledParticle : simpleCompiledParticles) {
            SimpleCompiledParticle compiled = (SimpleCompiledParticle) simpleCompiledParticle;

            NamespacedKey key = compiled.particle.getKey();
            Particle bukkitParticle = ParticleHelper.BUKKIT_MAP.get(key);
            if (bukkitParticle == null) {
                throw new UnsupportedOperationException("Could not find particle %s, please report this.".formatted(key.toString()));
            }

            ParticleOptions nmsParticle = CraftParticle.createParticleParam(bukkitParticle, compiled.data);
            particles.add(ParticleHelper.createPacket(nmsParticle, location, compiled));
        }

        return new ClientboundBundlePacket(particles);
    }
}
