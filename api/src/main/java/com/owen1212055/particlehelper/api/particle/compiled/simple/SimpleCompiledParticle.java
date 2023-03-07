package com.owen1212055.particlehelper.api.particle.compiled.simple;

import com.owen1212055.particlehelper.api.ParticleHelper;
import com.owen1212055.particlehelper.api.particle.MultiParticle;
import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.ApiStatus;

import java.util.function.BiConsumer;

@ApiStatus.Internal
public class SimpleCompiledParticle implements CompiledParticle {

    public ParticleType<?, ?> particle;

    public float offsetX;
    public float offsetY;
    public float offsetZ;
    public int count;
    public float speed;
    public boolean longDistance;

    public Object data;

    public BiConsumer<Player, Location> compiledSender;

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
        this.compiledSender.accept(player, location);
    }

    public CompiledParticle compileSender() {
        ParticleChannel channel = ParticleHelper.getActiveParticleChannel();
        this.compiledSender = channel.getSender(this);
        return this;
    }
}
