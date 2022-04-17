package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.*;

// Moved from origin to the spawn location
public interface DestinationParticle extends Particle {

    float getOriginX();

    void setOriginX(float x);

    float getOriginY();

    void setOriginY(float y);

    float getOriginZ();

    void setOriginZ(float z);

}
