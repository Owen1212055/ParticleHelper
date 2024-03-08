package com.owen1212055.particlehelper.plugin;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.ParticleChannel;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.nms.ParticleHelper;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.BiConsumer;

public class Plugin extends JavaPlugin implements Listener, ParticleChannel {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        com.owen1212055.particlehelper.api.ParticleHelper.bootstrapParticleChannel();
    }

    @Override
    public CompiledParticle getSingleSender(SimpleCompiledParticle simpleCompiledParticle) {
        return ParticleHelper.getSingleSender(simpleCompiledParticle);
    }

    @Override
    public CompiledParticle getGroupedSender(CompiledParticle... compiledParticles) {
        return ParticleHelper.getGroupedSender(compiledParticles);
    }

}
