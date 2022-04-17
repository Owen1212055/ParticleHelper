package com.owen1212055.particlehelper.api;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import org.bukkit.*;
import org.bukkit.entity.*;

import java.util.function.*;

public interface NmsSenderSupplier {

    BiConsumer<Player, Location> getSender(SimpleCompiledParticle particle);
}
