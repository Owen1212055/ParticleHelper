package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.Color;

/**
 * Represents a particle which can have its color modified.
 */
public interface ColorableParticle extends Particle {

    Color getColor();

    void setColor(Color color);
}
