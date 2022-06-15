package com.owen1212055.particlehelper.api.particle.types.velocity;

import com.owen1212055.particlehelper.api.particle.Particle;

/**
 * Represents a particle which can have its entire
 * velocity customized.
 */
public interface VelocityParticle extends Particle, YComponentVelocityParticle {

    float getVelocityX();

    void setVelocityX(float xVelocity);

    @Override
    float getVelocityY();

    @Override
    void setVelocityY(float yVelocity);

    float getVelocityZ();

    void setVelocityZ(float zVelocity);

}
