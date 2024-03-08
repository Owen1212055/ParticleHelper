package com.owen1212055.particlehelper.api;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.ParticleChannel;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class BukkitChannel implements ParticleChannel {


    @Override
    public CompiledParticle getSingleSender(SimpleCompiledParticle particle){
        return new CompiledParticle() {
            @Override
            public void send(Player player, Location location) {
                player.spawnParticle(
                        ParticleHelper.toBukkit(particle.particle),
                        location.getX(),
                        location.getY(),
                        location.getZ(),
                        particle.count,
                        particle.offsetX,
                        particle.offsetY,
                        particle.offsetZ,
                        particle.speed,
                        particle.data
                );
            }

            @Override
            public void sendToTrackingPlayers(Location location) {
                for (Player player : location.getWorld().getPlayers()) {
                    if (player.getLocation().distanceSquared(location) < ParticleHelper.MAGIC_TRACKING_RANGE) {
                        player.spawnParticle(
                                ParticleHelper.toBukkit(particle.particle),
                                location.getX(),
                                location.getY(),
                                location.getZ(),
                                particle.count,
                                particle.offsetX,
                                particle.offsetY,
                                particle.offsetZ,
                                particle.speed,
                                particle.data
                        );
                    }
                }
            }
        };
    }

    @Override
    public CompiledParticle getGroupedSender(CompiledParticle...particles){
        return new CompiledParticle() {
            @Override
            public void send(Player player, Location location) {
                for (CompiledParticle compiledParticle : particles) {
                    compiledParticle.send(player, location);
                }
            }

            @Override
            public void sendToTrackingPlayers(Location location) {
                for (CompiledParticle compiledParticle : particles) {
                    compiledParticle.sendToTrackingPlayers(location);
                }
            }
        };
    }

}
