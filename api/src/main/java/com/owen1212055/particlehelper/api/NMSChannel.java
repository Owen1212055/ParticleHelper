package com.owen1212055.particlehelper.api;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.ParticleChannel;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

class NMSChannel implements ParticleChannel {

    private final MethodHandle senderHandle;
    private final MethodHandle groupHandle;

    NMSChannel() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException {
        this.senderHandle = MethodHandles.lookup().findStatic(Class.forName("com.owen1212055.particlehelper.nms.ParticleHelper"), "getSingleSende", MethodType.methodType(CompiledParticle.class, CompiledParticle.class));
        this.groupHandle = MethodHandles.lookup().findStatic(Class.forName("com.owen1212055.particlehelper.nms.ParticleHelper"), "getGroupedSender", MethodType.methodType(CompiledParticle.class, CompiledParticle[].class));
    }


    @Override
    public CompiledParticle getSingleSender(SimpleCompiledParticle particle) {
        try {
            return (CompiledParticle) senderHandle.invoke(particle);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CompiledParticle getGroupedSender(CompiledParticle[] particles) {
        try {
            return (CompiledParticle) groupHandle.invoke((CompiledParticle[]) particles);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
