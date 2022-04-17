package com.owen1212055.particlehelper.api.particle.types.vibration;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.*;

public interface VibrationParticle extends Particle {

    Vibration getVibration();

    void setVibration(Vibration vibration);
}
