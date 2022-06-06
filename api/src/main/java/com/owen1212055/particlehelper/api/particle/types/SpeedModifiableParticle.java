package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;

public interface SpeedModifiableParticle extends Particle {

    float getSpeed();

    void setSpeed(float speed);

}
