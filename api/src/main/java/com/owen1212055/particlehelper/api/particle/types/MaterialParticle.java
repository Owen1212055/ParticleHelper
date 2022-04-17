package com.owen1212055.particlehelper.api.particle.types;

import com.owen1212055.particlehelper.api.particle.Particle;
import org.bukkit.*;

public interface MaterialParticle extends Particle {

    Material getMaterial();

    void setMaterial(Material material);
}
