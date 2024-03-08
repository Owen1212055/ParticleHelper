package com.owen1212055.particlehelper.nms;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import net.minecraft.network.protocol.*;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_20_R3.entity.*;
import org.bukkit.entity.*;

public abstract class ParticleSender implements CompiledParticle {

    private Packet<?> packet;
    private Location cached;

    @Override
    public void send(Player player, Location location) {
        Packet<?> target = this.getCached(location);

        ((CraftPlayer) player).getHandle().connection.send(target);
    }

    @Override
    public void sendToTrackingPlayers(Location location) {
        Packet<?> target = this.getCached(location);

        net.minecraft.world.phys.Vec3 vec3 = new net.minecraft.world.phys.Vec3(location.getX(), location.getY(), location.getZ());
        for (net.minecraft.server.level.ServerPlayer player : ((org.bukkit.craftbukkit.v1_20_R3.CraftWorld) location.getWorld()).getHandle().players()) {
            net.minecraft.core.BlockPos blockposition = player.blockPosition();
            if (blockposition.closerToCenterThan(vec3, 512.0)) {
                player.connection.send(target);
            }
        }
    }

    private Packet<?> getCached(Location location) {
        Packet<?> target;
        if (this.cached != null &&
                this.cached.getX() == location.getX() &&
                this.cached.getY() == location.getY() &&
                this.cached.getZ() == location.getZ()
        ) {
            target = this.packet;
        } else {
            target = createPacket(location);
            this.packet = target;
            this.cached = location.clone();
        }
        return target;
    }

    protected abstract Packet<?> createPacket(Location location);

}
