package com.owen1212055.particlehelper.api.particle.compiled;

import com.owen1212055.particlehelper.api.ParticleChannel;
import com.owen1212055.particlehelper.api.particle.MultiParticle;
import com.owen1212055.particlehelper.api.particle.Particle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.function.BiConsumer;

public class SimpleCompiledParticle implements CompiledParticle {

    private static ParticleChannel SENDER_SUPPLIER = null;

    public ParticleType<?, ?> particle;

    public float offsetX;
    public float offsetY;
    public float offsetZ;
    public int count;
    public float speed;
    public boolean longDistance;

    public Object data;

    public BiConsumer<Player, Location> compiledSender;

    public SimpleCompiledParticle(MultiParticle multiParticle) {
        this.particle = multiParticle.getType();
        this.offsetX = multiParticle.getXOffset();
        this.offsetY = multiParticle.getYOffset();
        this.offsetZ = multiParticle.getZOffset();
        this.count = multiParticle.getCount();
        this.longDistance = multiParticle.shouldForceSend();
    }

    public SimpleCompiledParticle(AbstractSingleParticle singleParticle) {
        this.particle = singleParticle.getType();
        this.count = 0;
    }

    public SimpleCompiledParticle(Particle particle) {
        this.longDistance = particle.shouldForceSend();
    }

    // Attempt to bind if this is shaded into a jar for example
    public static void forceBind() {
        if (SENDER_SUPPLIER == null) {
            return;
        }

        try {
            MethodType type = MethodType.methodType(BiConsumer.class, SimpleCompiledParticle.class);
            MethodHandle handle = MethodHandles.lookup().findStatic(Class.forName("com.owen1212055.particlehelper.nms.ParticleHelper"), "getParticleSender", type);

            SENDER_SUPPLIER = compiledParticle -> {
                try {
                    return (BiConsumer<Player, Location>) handle.invoke(compiledParticle);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }

            };
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void boostrap() {
        ParticleChannel supplier = (ParticleChannel) Bukkit.getPluginManager().getPlugin("ParticleHelper");
        if (supplier == null) {
            return;
        }

        SENDER_SUPPLIER = supplier;
    }

    public SimpleCompiledParticle compileSender() {
        if (this.compiledSender != null) {
            throw new IllegalStateException("Already compiled sender.");
        }

        forceBind();

        this.compiledSender = SENDER_SUPPLIER.getSender(this);

        return this;
    }

    @Override
    public void send(Player player, Location location) {
        if (compiledSender == null) {
            throw new IllegalStateException("Can't send compiled particle before the sender is finalized!");
        }

        compiledSender.accept(player, location);
    }
}
