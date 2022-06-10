package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;

public interface DelayableParticle extends Particle {

    int getDelay();

    void setDelay(int delay);
}
