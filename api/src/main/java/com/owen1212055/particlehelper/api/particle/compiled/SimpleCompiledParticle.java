package com.owen1212055.particlehelper.api.particle.compiled;

import com.owen1212055.particlehelper.api.*;
import com.owen1212055.particlehelper.api.particle.Particle;
import com.owen1212055.particlehelper.api.particle.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.*;
import org.bukkit.entity.*;

import java.lang.invoke.*;
import java.util.function.*;

public class SimpleCompiledParticle implements CompiledParticle {

    private static NmsSenderSupplier SENDER_SUPPLIER = null;

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


    public static void bind() {
        NmsSenderSupplier supplier = (NmsSenderSupplier) Bukkit.getPluginManager().getPlugin("ParticleHelper");
        if (supplier == null) {
            return;
        }

        SENDER_SUPPLIER = supplier;
    }
}
