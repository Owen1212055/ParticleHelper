package com.owen1212055.particlehelper.nms;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.type.ParticleType;
import net.minecraft.core.particles.*;
import net.minecraft.network.protocol.game.*;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_18_R2.*;
import org.bukkit.craftbukkit.v1_18_R2.entity.*;
import org.bukkit.entity.*;

import java.util.function.*;

import static com.owen1212055.particlehelper.api.type.Particles.*;

public class ParticleHelper {

    public static BiConsumer<Player, Location> getParticleSender(SimpleCompiledParticle compiledParticle) {
        ParticleOptions nmsParticle = CraftParticle.toNMS(toBukkit(compiledParticle.particle), compiledParticle.data);

        return new BiConsumer<>() {

            // Cache last sent
            private ClientboundLevelParticlesPacket cached;

            @Override
            public void accept(Player player, Location location) {
                ClientboundLevelParticlesPacket packet;

                // Locations same? Use same packet!
                if (cached != null && cached.getX() == location.getX() && cached.getY() == location.getY() && cached.getZ() == location.getZ()) {
                    packet = cached;
                } else {
                    packet = new ClientboundLevelParticlesPacket(nmsParticle,
                            compiledParticle.longDistance, location.getX(), location.getY(), location.getZ(),
                            compiledParticle.offsetX, compiledParticle.offsetY, compiledParticle.offsetZ, compiledParticle.speed, compiledParticle.count);
                    cached = packet;
                }

                ((CraftPlayer) player).getHandle().connection.send(packet);
            }
        };
    }

    public static org.bukkit.Particle toBukkit(ParticleType<?, ?> particle) {
        if (particle == POOF) return org.bukkit.Particle.EXPLOSION_NORMAL;
        if (particle == EXPLOSION) return org.bukkit.Particle.EXPLOSION_LARGE;
        if (particle == EXPLOSION_EMITTER) return org.bukkit.Particle.EXPLOSION_HUGE;
        if (particle == FIREWORK) return org.bukkit.Particle.FIREWORKS_SPARK;
        if (particle == BUBBLE) return org.bukkit.Particle.WATER_BUBBLE;
        if (particle == SPLASH) return org.bukkit.Particle.WATER_SPLASH;
        if (particle == FISHING) return org.bukkit.Particle.WATER_WAKE;
        if (particle == UNDERWATER) return org.bukkit.Particle.SUSPENDED_DEPTH;
        if (particle == CRIT) return org.bukkit.Particle.CRIT;
        if (particle == ENCHANTED_HIT) return org.bukkit.Particle.CRIT_MAGIC;
        if (particle == SMOKE) return org.bukkit.Particle.SMOKE_NORMAL;
        if (particle == LARGE_SMOKE) return org.bukkit.Particle.SMOKE_LARGE;
        if (particle == EFFECT) return org.bukkit.Particle.SPELL;
        if (particle == INSTANT_EFFECT) return org.bukkit.Particle.SPELL_INSTANT;
        if (particle == ENTITY_EFFECT) return org.bukkit.Particle.SPELL_MOB;
        if (particle == AMBIENT_ENTITY_EFFECT) return org.bukkit.Particle.SPELL_MOB_AMBIENT;
        if (particle == WITCH) return org.bukkit.Particle.SPELL_WITCH;
        if (particle == DRIPPING_WATER) return org.bukkit.Particle.DRIP_WATER;
        if (particle == DRIPPING_LAVA) return org.bukkit.Particle.DRIP_LAVA;
        if (particle == ANGRY_VILLAGER) return org.bukkit.Particle.VILLAGER_ANGRY;
        if (particle == HAPPY_VILLAGER) return org.bukkit.Particle.VILLAGER_HAPPY;
        if (particle == MYCELIUM) return org.bukkit.Particle.TOWN_AURA;
        if (particle == NOTE) return org.bukkit.Particle.NOTE;
        if (particle == PORTAL) return org.bukkit.Particle.PORTAL;
        if (particle == ENCHANT) return org.bukkit.Particle.ENCHANTMENT_TABLE;
        if (particle == FLAME) return org.bukkit.Particle.FLAME;
        if (particle == LAVA) return org.bukkit.Particle.LAVA;
        if (particle == CLOUD) return org.bukkit.Particle.CLOUD;
        if (particle == DUST) return org.bukkit.Particle.REDSTONE;
        if (particle == ITEM_SNOWBALL) return org.bukkit.Particle.SNOWBALL;
        if (particle == ITEM_SLIME) return org.bukkit.Particle.SLIME;
        if (particle == HEART) return org.bukkit.Particle.HEART;
        if (particle == ITEM) return org.bukkit.Particle.ITEM_CRACK;
        if (particle == BLOCK) return org.bukkit.Particle.BLOCK_CRACK;
        if (particle == RAIN) return org.bukkit.Particle.WATER_DROP;
        if (particle == ELDER_GUARDIAN) return org.bukkit.Particle.MOB_APPEARANCE;
        if (particle == DRAGON_BREATH) return org.bukkit.Particle.DRAGON_BREATH;
        if (particle == END_ROD) return org.bukkit.Particle.END_ROD;
        if (particle == DAMAGE_INDICATOR) return org.bukkit.Particle.DAMAGE_INDICATOR;
        if (particle == SWEEP_ATTACK) return org.bukkit.Particle.SWEEP_ATTACK;
        if (particle == FALLING_DUST) return org.bukkit.Particle.FALLING_DUST;
        if (particle == TOTEM_OF_UNDYING) return org.bukkit.Particle.TOTEM;
        if (particle == SPIT) return org.bukkit.Particle.SPIT;
        if (particle == SQUID_INK) return org.bukkit.Particle.SQUID_INK;
        if (particle == BUBBLE_POP) return org.bukkit.Particle.BUBBLE_POP;
        if (particle == CURRENT_DOWN) return org.bukkit.Particle.CURRENT_DOWN;
        if (particle == BUBBLE_COLUMN_UP) return org.bukkit.Particle.BUBBLE_COLUMN_UP;
        if (particle == NAUTILUS) return org.bukkit.Particle.NAUTILUS;
        if (particle == DOLPHIN) return org.bukkit.Particle.DOLPHIN;
        if (particle == SNEEZE) return org.bukkit.Particle.SNEEZE;
        if (particle == CAMPFIRE_COSY_SMOKE) return org.bukkit.Particle.CAMPFIRE_COSY_SMOKE;
        if (particle == CAMPFIRE_SIGNAL_SMOKE) return org.bukkit.Particle.CAMPFIRE_SIGNAL_SMOKE;
        if (particle == COMPOSTER) return org.bukkit.Particle.COMPOSTER;
        if (particle == FLASH) return org.bukkit.Particle.FLASH;
        if (particle == FALLING_LAVA) return org.bukkit.Particle.FALLING_LAVA;
        if (particle == LANDING_LAVA) return org.bukkit.Particle.LANDING_LAVA;
        if (particle == FALLING_WATER) return org.bukkit.Particle.FALLING_WATER;
        if (particle == DRIPPING_HONEY) return org.bukkit.Particle.DRIPPING_HONEY;
        if (particle == FALLING_HONEY) return org.bukkit.Particle.FALLING_HONEY;
        if (particle == LANDING_HONEY) return org.bukkit.Particle.LANDING_HONEY;
        if (particle == FALLING_NECTAR) return org.bukkit.Particle.FALLING_NECTAR;
        if (particle == SOUL_FIRE_FLAME) return org.bukkit.Particle.SOUL_FIRE_FLAME;
        if (particle == ASH) return org.bukkit.Particle.ASH;
        if (particle == CRIMSON_SPORE) return org.bukkit.Particle.CRIMSON_SPORE;
        if (particle == WARPED_SPORE) return org.bukkit.Particle.WARPED_SPORE;
        if (particle == SOUL) return org.bukkit.Particle.SOUL;
        if (particle == DRIPPING_OBSIDIAN_TEAR) return org.bukkit.Particle.DRIPPING_OBSIDIAN_TEAR;
        if (particle == FALLING_OBSIDIAN_TEAR) return org.bukkit.Particle.FALLING_OBSIDIAN_TEAR;
        if (particle == LANDING_OBSIDIAN_TEAR) return org.bukkit.Particle.LANDING_OBSIDIAN_TEAR;
        if (particle == REVERSE_PORTAL) return org.bukkit.Particle.REVERSE_PORTAL;
        if (particle == WHITE_ASH) return org.bukkit.Particle.WHITE_ASH;
        if (particle == DUST_COLOR_TRANSITION) return org.bukkit.Particle.DUST_COLOR_TRANSITION;
        if (particle == VIBRATION) return org.bukkit.Particle.VIBRATION;
        if (particle == FALLING_SPORE_BLOSSOM) return org.bukkit.Particle.FALLING_SPORE_BLOSSOM;
        if (particle == SPORE_BLOSSOM_AIR) return org.bukkit.Particle.SPORE_BLOSSOM_AIR;
        if (particle == SMALL_FLAME) return org.bukkit.Particle.SMALL_FLAME;
        if (particle == SNOWFLAKE) return org.bukkit.Particle.SNOWFLAKE;
        if (particle == DRIPPING_DRIPSTONE_LAVA) return org.bukkit.Particle.DRIPPING_DRIPSTONE_LAVA;
        if (particle == FALLING_DRIPSTONE_LAVA) return org.bukkit.Particle.FALLING_DRIPSTONE_LAVA;
        if (particle == DRIPPING_DRIPSTONE_WATER) return org.bukkit.Particle.DRIPPING_DRIPSTONE_WATER;
        if (particle == FALLING_DRIPSTONE_WATER) return org.bukkit.Particle.FALLING_DRIPSTONE_WATER;
        if (particle == GLOW_SQUID_INK) return org.bukkit.Particle.GLOW_SQUID_INK;
        if (particle == GLOW) return org.bukkit.Particle.GLOW;
        if (particle == WAX_ON) return org.bukkit.Particle.WAX_ON;
        if (particle == WAX_OFF) return org.bukkit.Particle.WAX_OFF;
        if (particle == ELECTRIC_SPARK) return org.bukkit.Particle.ELECTRIC_SPARK;
        if (particle == SCRAPE) return org.bukkit.Particle.SCRAPE;
        if (particle == BLOCK_MARKER) return org.bukkit.Particle.BLOCK_MARKER;

        throw new UnsupportedOperationException();
    }
}
