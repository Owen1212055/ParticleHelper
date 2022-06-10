package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;

public interface RollableParticle extends Particle {

    float getRoll();

    void setRoll(float roll);
}
