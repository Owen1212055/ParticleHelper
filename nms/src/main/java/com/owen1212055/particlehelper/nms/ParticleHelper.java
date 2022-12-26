package com.owen1212055.particlehelper.nms;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.protocol.game.ClientboundLevelParticlesPacket;
import net.minecraft.resources.ResourceKey;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_19_R2.CraftParticle;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_19_R2.util.CraftNamespacedKey;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@SuppressWarnings("unused")
public class ParticleHelper {


    /*
    Iterate over the Minecraft particles to map it to the bukkit api equivalents.
     */
    private static final Map<NamespacedKey, Particle> BUKKIT_MAP = new HashMap<>();

    static {
        Registry<net.minecraft.core.particles.ParticleType<?>> particleTypes = BuiltInRegistries.PARTICLE_TYPE;
        for (Map.Entry<ResourceKey<net.minecraft.core.particles.ParticleType<?>>, net.minecraft.core.particles.ParticleType<?>> particleType : particleTypes.entrySet()) {
            BUKKIT_MAP.put(CraftNamespacedKey.fromMinecraft(particleType.getKey().location()), CraftParticle.toBukkit(particleType.getValue()));
        }
    }

    public static BiConsumer<Player, Location> getParticleSender(CompiledParticle compiledParticle) {
        SimpleCompiledParticle compiled;
        if (!(compiledParticle instanceof SimpleCompiledParticle)) {
            throw new UnsupportedOperationException();
        } else {
            compiled = (SimpleCompiledParticle) compiledParticle;
        }

        NamespacedKey key = compiled.particle.getKey();
        Particle bukkitParticle = BUKKIT_MAP.get(key);
        if (bukkitParticle == null) {
            throw new UnsupportedOperationException("Could not find particle %s, please report this.".formatted(key.toString()));
        }

        ParticleOptions nmsParticle = CraftParticle.toNMS(bukkitParticle, compiled.data);

        return new BiConsumer<>() {

            // Cache last sent
            private ClientboundLevelParticlesPacket cached;

            @Override
            public void accept(Player player, Location location) {
                ClientboundLevelParticlesPacket packet;

                // Locations same? Use same packet!
                if (cached != null && cached.getX() == location.getX() && cached.getY() == location.getY() && cached.getZ() == location.getZ()) {
                    packet = cached;
                } else {
                    packet = new ClientboundLevelParticlesPacket(nmsParticle,
                            compiled.longDistance, location.getX(), location.getY(), location.getZ(),
                            compiled.offsetX, compiled.offsetY, compiled.offsetZ, compiled.speed, compiled.count);
                    cached = packet;
                }

                ((CraftPlayer) player).getHandle().connection.send(packet);
            }
        };
    }

}
