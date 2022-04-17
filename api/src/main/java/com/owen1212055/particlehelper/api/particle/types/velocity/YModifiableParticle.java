package com.owen1212055.particlehelper.api.particle.types.velocity;

import com.owen1212055.particlehelper.api.particle.*;

// Some particles can only have their Y coordinates changed
public interface YModifiableParticle extends Particle {

    float getVelocityY();

    void setVelocityY(float yVelocity);

}
