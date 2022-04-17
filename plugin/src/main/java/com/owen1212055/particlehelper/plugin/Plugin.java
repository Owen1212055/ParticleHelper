package com.owen1212055.particlehelper.plugin;

import com.owen1212055.particlehelper.api.*;
import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import com.owen1212055.particlehelper.nms.*;
import io.papermc.paper.event.player.*;
import net.kyori.adventure.text.serializer.plain.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.plugin.java.*;

import java.util.function.*;

public class Plugin extends JavaPlugin implements Listener, NmsSenderSupplier {

    Color color = Color.BLUE;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        SimpleCompiledParticle.bind();
    }

    @EventHandler
    public void onSwapHands(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();

        ColorableParticle colorableParticle = Particles.NOTE.single();
        colorableParticle.setColor(color);
        colorableParticle.send(player, location);
    }

    @EventHandler
    public void onChat(AsyncChatEvent event) {
        String rgb = PlainTextComponentSerializer.plainText().serialize(event.originalMessage());
        String[] args = rgb.split(" ");

        color = Color.fromRGB(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }

    @Override
    public BiConsumer<Player, Location> getSender(SimpleCompiledParticle particle) {
        return ParticleHelper.getParticleSender(particle);
    }
}
