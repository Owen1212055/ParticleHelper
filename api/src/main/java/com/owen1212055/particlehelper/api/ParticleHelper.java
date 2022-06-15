package com.owen1212055.particlehelper.api;


import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.ParticleChannel;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.function.BiConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.owen1212055.particlehelper.api.type.Particles.*;
import static com.owen1212055.particlehelper.api.type.Particles.SONIC_BOOM;

public final class ParticleHelper {

    private static final Logger LOGGER = Logger.getLogger("ParticleHelper");

    private static ParticleChannel ACTIVE_PARTICLE_CHANNEL= null;

    /**
     * Attempts to setup the particle channel for sending
     * particles to players.
     *
     * This will first try to use NMS, where if that fails the bukkit api
     * will be used instead.
     */
    public static void bootstrapParticleChannel() {
        if (ACTIVE_PARTICLE_CHANNEL != null) {
            return;
        }

        try {
            MethodType type = MethodType.methodType(BiConsumer.class, CompiledParticle.class);
            MethodHandle handle = MethodHandles.lookup().findStatic(Class.forName("com.owen1212055.particlehelper.nms.ParticleHelper"), "getParticleSender", type);

            ACTIVE_PARTICLE_CHANNEL = compiledParticle -> {
                try {
                    return (BiConsumer<Player, Location>) handle.invoke(compiledParticle);
                } catch (ReflectiveOperationException e) {
                    LOGGER.log(Level.WARNING, "Failed to fetch certain NMS classes! Using bukkit API (less performant & ignores forceSend).", e);
                    // Reassign cached + main channel.
                    bukkitBind();
                    compiledParticle.compiledSender = ACTIVE_PARTICLE_CHANNEL.getSender(compiledParticle);

                    // Reassigned, so now send via bucket.
                    return compiledParticle.compiledSender;
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            };
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Failed to create native particle sender! Using bukkit API (less performant & ignores forceSend).", e);
            bukkitBind();
        }
    }

    @Nullable
    @ApiStatus.Internal
    public static ParticleChannel getActiveParticleChannel() {
        if (ACTIVE_PARTICLE_CHANNEL == null) {
            bootstrapParticleChannel();
        }

        return ACTIVE_PARTICLE_CHANNEL;
    }

    // Attempt to bind if this is shaded into a jar for example
    private static void bukkitBind() {
        ACTIVE_PARTICLE_CHANNEL = particle -> (player, location) -> {
            // Unsupported: force send
            player.spawnParticle(
                    toBukkit(particle.particle),
                    location.getX(),
                    location.getY(),
                    location.getZ(),
                    particle.count,
                    particle.offsetX,
                    particle.offsetY,
                    particle.offsetZ,
                    particle.speed,
                    particle.data
            );
        };
    }

    // YUCKY!
    // I swear do not reflect into this. Crimes against humanity.
    private static org.bukkit.Particle toBukkit(ParticleType<?, ?> particle) {
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
        if (particle == SCULK_CHARGE) return org.bukkit.Particle.SCULK_CHARGE;
        if (particle == SCULK_CHARGE_POP) return org.bukkit.Particle.SCULK_CHARGE_POP;
        if (particle == SHRIEK) return org.bukkit.Particle.SHRIEK;
        if (particle == SONIC_BOOM) return org.bukkit.Particle.SONIC_BOOM;

        throw new UnsupportedOperationException();
    }

}
