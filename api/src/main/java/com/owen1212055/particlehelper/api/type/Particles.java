package com.owen1212055.particlehelper.api.type;

import com.owen1212055.particlehelper.api.particle.Particle;
import com.owen1212055.particlehelper.api.particle.types.common.SimpleMultiParticle;
import com.owen1212055.particlehelper.api.particle.types.common.SimpleSingleParticle;
import com.owen1212055.particlehelper.api.particle.types.common.blockdata.MultiBlockDataParticle;
import com.owen1212055.particlehelper.api.particle.types.common.blockdata.SingleBlockDataParticle;
import com.owen1212055.particlehelper.api.particle.types.common.destination.SingleDestinationParticle;
import com.owen1212055.particlehelper.api.particle.types.common.size.MultiSizeParticle;
import com.owen1212055.particlehelper.api.particle.types.common.size.SingleSizeParticle;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.MultiSpeedModifiableParticle;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.ReducedMomentumParticle;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.SingleRisingParticle;
import com.owen1212055.particlehelper.api.particle.types.common.velocity.VelocityParticleImpl;
import com.owen1212055.particlehelper.api.particle.types.dust.simple.MultiDustParticle;
import com.owen1212055.particlehelper.api.particle.types.dust.simple.SingleDustParticle;
import com.owen1212055.particlehelper.api.particle.types.dust.transition.MultiDustTransitionParticle;
import com.owen1212055.particlehelper.api.particle.types.dust.transition.SingleDustTransitionParticle;
import com.owen1212055.particlehelper.api.particle.types.entityeffect.MultiEntityEffectParticle;
import com.owen1212055.particlehelper.api.particle.types.entityeffect.SingleEntityEffectParticle;
import com.owen1212055.particlehelper.api.particle.types.itemcrack.MultiItemCrackParticle;
import com.owen1212055.particlehelper.api.particle.types.itemcrack.SingleItemCrackParticle;
import com.owen1212055.particlehelper.api.particle.types.note.MultiNoteParticle;
import com.owen1212055.particlehelper.api.particle.types.note.SingleNoteParticle;
import com.owen1212055.particlehelper.api.particle.types.sculkcharge.MultiSculkChargeParticle;
import com.owen1212055.particlehelper.api.particle.types.sculkcharge.SingleSculkChargeParticle;
import com.owen1212055.particlehelper.api.particle.types.shriek.MultiShriekParticle;
import com.owen1212055.particlehelper.api.particle.types.shriek.SingleShriekParticle;
import com.owen1212055.particlehelper.api.particle.types.vibration.MultiVibrationParticle;
import com.owen1212055.particlehelper.api.particle.types.vibration.SingleVibrationParticle;

import java.util.function.Function;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.Nullable;

public interface Particles {

    ParticleType<SingleEntityEffectParticle, MultiEntityEffectParticle> AMBIENT_ENTITY_EFFECT = of("ambient_entity_effect", SingleEntityEffectParticle::new, MultiEntityEffectParticle::new);
    StaticParticle ANGRY_VILLAGER = ofStatic("angry_villager");
    StaticParticle ASH = ofStatic("ash");
    ParticleType<SingleBlockDataParticle, MultiBlockDataParticle> BLOCK = of("block", SingleBlockDataParticle::new, MultiBlockDataParticle::new);
    ParticleType<SingleBlockDataParticle, MultiBlockDataParticle> BLOCK_MARKER = of("block_marker", SingleBlockDataParticle::new, MultiBlockDataParticle::new);
    MoveableParticle BUBBLE = ofMoveable("bubble");
    MoveableParticle BUBBLE_COLUMN_UP = ofMoveable("bubble_column_up");
    MoveableParticle BUBBLE_POP = ofMoveable("bubble_pop");
    MoveableParticle CAMPFIRE_COSY_SMOKE = ofMoveable("campfire_cosy_smoke");
    MoveableParticle CAMPFIRE_SIGNAL_SMOKE = ofMoveable("campfire_signal_smoke");
    MoveableParticle CLOUD = ofMoveable("cloud");
    MoveableParticle COMPOSTER = ofMoveable("composter");
    StaticParticle CRIMSON_SPORE = ofStatic("crimson_spore");
    MoveableParticle CRIT = ofMoveable("crit");
    StaticParticle CURRENT_DOWN = ofStatic("current_down");
    MoveableParticle DAMAGE_INDICATOR = ofMoveable("damage_indicator");
    MoveableParticle DOLPHIN = ofMoveable("dolphin");
    MoveableParticle DRAGON_BREATH = ofMoveable("dragon_breath");
    StaticParticle DRIPPING_DRIPSTONE_LAVA = ofStatic("dripping_dripstone_lava");
    StaticParticle DRIPPING_DRIPSTONE_WATER = ofStatic("dripping_dripstone_water");
    StaticParticle DRIPPING_HONEY = ofStatic("dripping_honey");
    StaticParticle DRIPPING_LAVA = ofStatic("dripping_lava");
    StaticParticle DRIPPING_OBSIDIAN_TEAR = ofStatic("dripping_obsidian_tear");
    StaticParticle DRIPPING_WATER = ofStatic("dripping_water");
    ParticleType<SingleDustParticle, MultiDustParticle> DUST = of("dust", SingleDustParticle::new, MultiDustParticle::new);
    ParticleType<SingleDustTransitionParticle, MultiDustTransitionParticle> DUST_COLOR_TRANSITION = of("dust_color_transition", SingleDustTransitionParticle::new, MultiDustTransitionParticle::new);
    ParticleType<ReducedMomentumParticle, MultiSpeedModifiableParticle> EFFECT = of("effect", ReducedMomentumParticle::new, MultiSpeedModifiableParticle::new);
    MoveableParticle EGG_CRACK = ofMoveable("egg_crack");
    StaticParticle ELDER_GUARDIAN = ofStatic("elder_guardian");
    MoveableParticle ELECTRIC_SPARK = ofMoveable("electric_spark");
    ParticleType<SingleDestinationParticle, MultiSpeedModifiableParticle> ENCHANT = of("enchant", SingleDestinationParticle::new, MultiSpeedModifiableParticle::new);
    MoveableParticle ENCHANTED_HIT = ofMoveable("enchanted_hit");
    MoveableParticle END_ROD = ofMoveable("end_rod");
    ParticleType<SingleEntityEffectParticle, MultiEntityEffectParticle> ENTITY_EFFECT = of("entity_effect", SingleEntityEffectParticle::new, MultiEntityEffectParticle::new);
    ParticleType<SingleSizeParticle, MultiSizeParticle> EXPLOSION = of("explosion", SingleSizeParticle::new, MultiSizeParticle::new);
    StaticParticle EXPLOSION_EMITTER = ofStatic("explosion_emitter");
    StaticParticle FALLING_DRIPSTONE_LAVA = ofStatic("falling_dripstone_lava");
    StaticParticle FALLING_DRIPSTONE_WATER = ofStatic("falling_dripstone_water");
    ParticleType<SingleBlockDataParticle, MultiBlockDataParticle> FALLING_DUST = of("falling_dust", SingleBlockDataParticle::new, MultiBlockDataParticle::new);
    StaticParticle FALLING_HONEY = ofStatic("falling_honey");
    StaticParticle FALLING_LAVA = ofStatic("falling_lava");
    StaticParticle FALLING_NECTAR = ofStatic("falling_nectar");
    StaticParticle FALLING_OBSIDIAN_TEAR = ofStatic("falling_obsidian_tear");
    StaticParticle FALLING_SPORE_BLOSSOM = ofStatic("falling_spore_blossom");
    StaticParticle FALLING_WATER = ofStatic("falling_water");
    MoveableParticle FIREWORK = ofMoveable("firework");
    MoveableParticle FISHING = ofMoveable("fishing");
    StaticParticle FLASH = ofStatic("flash");
    MoveableParticle FLAME = ofMoveable("flame");
    StaticParticle CHERRY_LEAVES = ofStatic("cherry_leaves");
    ParticleType<ReducedMomentumParticle, MultiSpeedModifiableParticle> GLOW = of("glow", ReducedMomentumParticle::new, MultiSpeedModifiableParticle::new);
    MoveableParticle GLOW_SQUID_INK = ofMoveable("glow_squid_ink");
    MoveableParticle HAPPY_VILLAGER = ofMoveable("happy_villager");
    StaticParticle HEART = ofStatic("heart");
    ParticleType<SingleRisingParticle, MultiSpeedModifiableParticle> INSTANT_EFFECT = of("instant_effect", SingleRisingParticle::new, MultiSpeedModifiableParticle::new);
    ParticleType<SingleItemCrackParticle, MultiItemCrackParticle> ITEM = of("item", SingleItemCrackParticle::new, MultiItemCrackParticle::new);
    StaticParticle ITEM_SLIME = ofStatic("item_slime");
    StaticParticle ITEM_SNOWBALL = ofStatic("item_snowball");
    StaticParticle LANDING_HONEY = ofStatic("landing_honey");
    StaticParticle LANDING_LAVA = ofStatic("landing_lava");
    StaticParticle LANDING_OBSIDIAN_TEAR = ofStatic("landing_obsidian_tear");
    MoveableParticle LARGE_SMOKE = ofMoveable("large_smoke");
    StaticParticle LAVA = ofStatic("lava");
    MoveableParticle MYCELIUM = ofMoveable("mycelium");
    ParticleType<SingleDestinationParticle, MultiSpeedModifiableParticle> NAUTILUS = of("nautilus", SingleDestinationParticle::new, MultiSpeedModifiableParticle::new);
    ParticleType<SingleNoteParticle, MultiNoteParticle> NOTE = of("note", SingleNoteParticle::new, MultiNoteParticle::new);
    MoveableParticle POOF = ofMoveable("poof");
    ParticleType<SingleDestinationParticle, MultiSpeedModifiableParticle> PORTAL = of("portal", SingleDestinationParticle::new, MultiSpeedModifiableParticle::new);
    StaticParticle RAIN = ofStatic("rain");
    MoveableParticle REVERSE_PORTAL = ofMoveable("reverse_portal");
    MoveableParticle SCRAPE = ofMoveable("scrape");
    ParticleType<SingleSculkChargeParticle, MultiSculkChargeParticle> SCULK_CHARGE = of("sculk_charge", SingleSculkChargeParticle::new, MultiSculkChargeParticle::new);
    MoveableParticle SCULK_CHARGE_POP = ofMoveable("sculk_charge_pop");
    MoveableParticle SCULK_SOUL = ofMoveable("sculk_soul");
    ParticleType<SingleShriekParticle, MultiShriekParticle> SHRIEK = of("shriek", SingleShriekParticle::new, MultiShriekParticle::new);
    StaticParticle SONIC_BOOM = ofStatic("sonic_boom");
    MoveableParticle SMALL_FLAME = ofMoveable("small_flame");
    MoveableParticle SMOKE = ofMoveable("smoke");
    MoveableParticle SNEEZE = ofMoveable("sneeze");
    MoveableParticle SNOWFLAKE = ofMoveable("snowflake");
    MoveableParticle SOUL = ofMoveable("soul");
    MoveableParticle SOUL_FIRE_FLAME = ofMoveable("soul_fire_flame");
    MoveableParticle SPIT = ofMoveable("spit");
    MoveableParticle SPLASH = ofMoveable("splash");
    StaticParticle SPORE_BLOSSOM_AIR = ofStatic("spore_blossom_air");
    MoveableParticle SQUID_INK = ofMoveable("squid_ink");
    ParticleType<SingleSizeParticle, MultiSizeParticle> SWEEP_ATTACK = of("sweep_attack", SingleSizeParticle::new, MultiSizeParticle::new);
    MoveableParticle TOTEM_OF_UNDYING = ofMoveable("totem_of_undying");
    StaticParticle UNDERWATER = ofStatic("underwater");
    ParticleType<SingleVibrationParticle, MultiVibrationParticle> VIBRATION = of("vibration", SingleVibrationParticle::new, MultiVibrationParticle::new);
    StaticParticle WARPED_SPORE = ofStatic("warped_spore");
    MoveableParticle WAX_OFF = ofMoveable("wax_off");
    MoveableParticle WAX_ON = ofMoveable("wax_on");
    StaticParticle WHITE_ASH = ofStatic("white_ash");
    ParticleType<SingleRisingParticle, MultiSpeedModifiableParticle> WITCH = of("witch", SingleRisingParticle::new, MultiSpeedModifiableParticle::new);

    /**
     * Method for getting a particle from its namespacekey.
     * Backwards compatability with old keys is not promised!
     *
     * @param key particle key
     * @return particle
     */
    @Nullable
    static ParticleType<?,?> fromKey(NamespacedKey key) {
        return ParticleRegistry.getParticle(key);
    }

    private static MoveableParticle ofMoveable(String name) {
        MoveableParticle particle = new MoveableParticle.ApiParticle(NamespacedKey.minecraft(name), VelocityParticleImpl::new, MultiSpeedModifiableParticle::new);
        ParticleRegistry.register(particle);
        return particle;
    }

    private static StaticParticle ofStatic(String name) {
        StaticParticle particle = new StaticParticle.ApiParticle(NamespacedKey.minecraft(name), SimpleSingleParticle::new, SimpleMultiParticle::new);
        ParticleRegistry.register(particle);
        return particle;
    }

    private static <S extends Particle<?>, M extends Particle<?>> ParticleType<S, M> of(String name, Function<ParticleType<S, M>, S> supplier, Function<ParticleType<S, M>, M> supplier2) {
        ApiParticle<S, M> particle =  new ApiParticle<>(NamespacedKey.minecraft(name), supplier, supplier2);
        ParticleRegistry.register(particle);
        return particle;
    }

}
