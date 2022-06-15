package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;

/**
 * Represents a particle that is able to have its
 * overall speed adjusted.
 */
public interface SpeedModifiableParticle extends Particle {

    float getSpeed();

    void setSpeed(float speed);

}
