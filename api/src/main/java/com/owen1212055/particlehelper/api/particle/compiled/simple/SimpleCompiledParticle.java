package com.owen1212055.particlehelper.api.particle.compiled.simple;

import com.owen1212055.particlehelper.api.*;
import com.owen1212055.particlehelper.api.particle.*;
import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.jetbrains.annotations.*;

@ApiStatus.Internal
public class SimpleCompiledParticle implements CompiledParticle {

    @ApiStatus.Internal
    public ParticleType<?, ?> particle;

    @ApiStatus.Internal
    public float offsetX;
    @ApiStatus.Internal
    public float offsetY;
    @ApiStatus.Internal
    public float offsetZ;
    @ApiStatus.Internal
    public int count;
    @ApiStatus.Internal
    public float speed;
    @ApiStatus.Internal
    public boolean longDistance;
    @ApiStatus.Internal
    public Object data;

    @ApiStatus.Internal
    public CompiledParticle compiledSender;

    public SimpleCompiledParticle(MultiParticle<?> multiParticle) {
        this.particle = multiParticle.getType();
        this.offsetX = multiParticle.xOffset();
        this.offsetY = multiParticle.yOffset();
        this.offsetZ = multiParticle.zOffset();
        this.count = multiParticle.count();
        this.longDistance = multiParticle.forceShow();
    }

    public SimpleCompiledParticle(AbstractSingleParticle<?> singleParticle) {
        this.particle = singleParticle.getType();
        this.count = 0;
        this.longDistance = singleParticle.forceShow();
    }

    @Override
    public void send(Player player, Location location) {
        this.compiledSender.send(player, location);
    }

    @Override
    public void sendToTrackingPlayers(org.bukkit.Location location) {
        this.compiledSender.sendToTrackingPlayers(location);
    }

    public CompiledParticle compileSender() {
        ParticleChannel channel = ParticleHelper.getActiveParticleChannel();
        this.compiledSender = channel.getSingleSender(this);
        return this;
    }
}
