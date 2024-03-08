package com.owen1212055.particlehelper.plugin;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.compiled.simple.*;
import com.owen1212055.particlehelper.nms.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

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
