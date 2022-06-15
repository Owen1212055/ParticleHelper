package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;

/**
 * Represents a particle that has a delay (in ticks) before
 * starting to be rendered.
 */
public interface DelayableParticle extends Particle {

    int getDelay();

    void setDelay(int delay);
}
