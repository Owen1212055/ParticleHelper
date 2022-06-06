package com.owen1212055.particlehelper.plugin;

import com.owen1212055.particlehelper.api.ParticleChannel;
import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.ColorableParticle;
import com.owen1212055.particlehelper.api.particle.types.note.MultiNoteParticle;
import com.owen1212055.particlehelper.api.particle.types.note.SingleNoteParticle;
import com.owen1212055.particlehelper.api.type.Particles;
import com.owen1212055.particlehelper.nms.ParticleHelper;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.BiConsumer;

public class Plugin extends JavaPlugin implements Listener, ParticleChannel {

    //Color color = Color.BLUE;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        SimpleCompiledParticle.boostrap();
        {
            // Send a single blue note to the player
            ColorableParticle noteParticle = Particles.NOTE.single();
            noteParticle.setColor(Color.fromRGB(0, 0, 255));


            // Send to a specific player
            Player player = Bukkit.getPlayer("bob");
            noteParticle.send(player, player.getLocation());

            // Send to a bunch of players, prevent allocating a bunch of objects
            Location location = new Location(null, 0, 0,0); // PluginHelper will reuse the same packet if the location is the same
            CompiledParticle compiledParticle = noteParticle.compile();
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                compiledParticle.send(onlinePlayer, location);
            }

        }

        {
            // Send a bulk note particle
            MultiNoteParticle noteParticle = Particles.NOTE.multi();
            noteParticle.setColorMultplier(0.5F); // Note we lose the ability to individually modify the particle.
            noteParticle.setYOffset(10);
            noteParticle.setCount(90);

            // Send to a specific player
            Player player = Bukkit.getPlayer("bob");
            noteParticle.send(player, player.getLocation());
        }


    }
    /*
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
    */

    @Override
    public BiConsumer<Player, Location> getSender(SimpleCompiledParticle particle) {
        return ParticleHelper.getParticleSender(particle);
    }
}
