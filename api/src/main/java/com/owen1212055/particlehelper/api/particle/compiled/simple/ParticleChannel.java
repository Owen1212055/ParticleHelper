package com.owen1212055.particlehelper.api.particle.compiled.simple;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import org.jetbrains.annotations.*;

/**
 * Internally used for sending simple compiled particles without using
 * the bukkit api.
 */
@ApiStatus.Internal
public interface ParticleChannel {

    CompiledParticle getSingleSender(SimpleCompiledParticle particle);

    CompiledParticle getGroupedSender(CompiledParticle... particles);

}