package com.owen1212055.particlehelper.api.particle.types.velocity;

import com.owen1212055.particlehelper.api.particle.*;

public interface VelocityModifiableParticle extends Particle, YModifiableParticle {

    float getVelocityX();

    void setVelocityX(float xVelocity);

    @Override
    float getVelocityY();

    @Override
    void setVelocityY(float yVelocity);

    float getVelocityZ();

    void setVelocityZ(float zVelocity);

}
