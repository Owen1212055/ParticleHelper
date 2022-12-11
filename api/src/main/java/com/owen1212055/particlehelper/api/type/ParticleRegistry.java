package com.owen1212055.particlehelper.api.type;

import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

class ParticleRegistry {

    private static final Map<Key, ParticleType<?, ?>> TYPE_MAP = new HashMap<>();

    static void register(ParticleType<?, ?> particleType) {
        TYPE_MAP.put(particleType.getKey(), particleType);
    }

    @Nullable
    static ParticleType<?, ?> getParticle(Key namespacedKey) {
        return TYPE_MAP.get(namespacedKey);
    }

}
