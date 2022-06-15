package com.owen1212055.particlehelper.api.particle.types.velocity;

import com.owen1212055.particlehelper.api.particle.Particle;

/**
 * Represents a particle which can only have
 * its y component modified in its velocity.
 */
public interface YComponentVelocityParticle extends Particle {

    float getVelocityY();

    void setVelocityY(float yVelocity);

}
