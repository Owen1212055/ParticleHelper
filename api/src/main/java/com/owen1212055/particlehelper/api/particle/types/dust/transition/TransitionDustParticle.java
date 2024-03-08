package com.owen1212055.particlehelper.api.particle.types.dust.transition;

import com.owen1212055.particlehelper.api.particle.Particle;
import com.owen1212055.particlehelper.api.particle.types.dust.*;
import org.bukkit.*;
import org.jetbrains.annotations.*;

public interface TransitionDustParticle<T extends Particle<T>> extends DustParticle<T> {

    /**
     * Gets the color that this dust particle will transition to.
     * @return fade color
     */
    @NotNull
    Color fadeColor();

    /**
     * Sets the color that this particle will transition into.
     * @param color fade color
     */
    @Contract("_ -> this")
    @NotNull T fadeColor(@NotNull Color color);
}
