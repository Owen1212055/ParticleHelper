package com.owen1212055.particlehelper.api.particle.types.dust.transition;

import com.owen1212055.particlehelper.api.particle.types.dust.*;
import org.bukkit.*;

public interface TransitionDustParticle extends DustParticle {

    Color getFadeColor();

    void setFadeColor(Color color);
}
