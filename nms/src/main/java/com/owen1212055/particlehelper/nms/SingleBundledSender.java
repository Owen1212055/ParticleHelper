package com.owen1212055.particlehelper.nms;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBundlePacket;
import net.minecraft.network.protocol.game.ClientboundLevelParticlesPacket;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_20_R3.CraftParticle;

import java.util.ArrayList;
import java.util.List;

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
