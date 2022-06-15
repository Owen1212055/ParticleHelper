package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;

/**
 * Represents a particle that will start at the given position and move towards
 * its spawning location.
 */
public interface DestinationParticle extends Particle {

    float getOriginX();

    void setOriginX(float x);

    float getOriginY();

    void setOriginY(float y);

    float getOriginZ();

    void setOriginZ(float z);

}
