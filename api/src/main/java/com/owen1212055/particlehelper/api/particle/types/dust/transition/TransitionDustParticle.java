package com.owen1212055.particlehelper.api.particle.types.dust.transition;

import com.owen1212055.particlehelper.api.particle.types.dust.DustParticle;
import org.bukkit.Color;
import org.jetbrains.annotations.NotNull;

public interface TransitionDustParticle extends DustParticle {

    /**
     * Gets the color that this dust particle will transition to.
     * @return fade color
     */
    @NotNull
    Color getFadeColor();

    /**
     * Sets the color that this particle will transition into.
     * @param color fade color
     */
    void setFadeColor(@NotNull Color color);
}
