package com.owen1212055.particlehelper.nms;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBundlePacket;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_20_R3.CraftParticle;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

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
