package com.owen1212055.particlehelper.api.type;

import org.bukkit.*;
import org.jetbrains.annotations.*;

import java.util.*;

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
