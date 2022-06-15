package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;

/**
 * Represents a particle that is
 * able to have its size modified.
 */
public interface SizeableParticle extends Particle {

    float getSize();

    void setSize(float size);
}
