package com.owen1212055.particlehelper.api.type;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.Nullable;

class ParticleRegistry {

    private static final Map<NamespacedKey, ParticleType<?, ?>> TYPE_MAP = new HashMap<>();

    static void register(ParticleType<?, ?> particleType) {
        TYPE_MAP.put(particleType.getKey(), particleType);
    }

    @Nullable
    static ParticleType<?, ?> getParticle(NamespacedKey namespacedKey) {
        return TYPE_MAP.get(namespacedKey);
    }

}
