package com.owen1212055.particlehelper.api.particle.types.vibration;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.Vibration;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a particle with a vibration.
 */
public interface VibrationParticle extends Particle {

    @NotNull
    Vibration getVibration();

    void setVibration(@NotNull Vibration vibration);
}
