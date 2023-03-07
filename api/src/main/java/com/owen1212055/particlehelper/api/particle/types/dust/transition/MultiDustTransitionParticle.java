package com.owen1212055.particlehelper.api.particle.types.dust.transition;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.dust.MultiDustParticleImpl;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.jetbrains.annotations.NotNull;

public class MultiDustTransitionParticle extends MultiDustParticleImpl<MultiDustTransitionParticle> implements TransitionDustParticle<MultiDustTransitionParticle> {

    private Color fade;

    public MultiDustTransitionParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public @NotNull Color fadeColor() {
        return this.fade;
    }

    @Override
    public @NotNull MultiDustTransitionParticle fadeColor(@NotNull Color color) {
        this.fade = color;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.speed = 1; // Keep speed constant
        simpleCompiledParticle.data = new Particle.DustTransition(color, fade, size);

        return simpleCompiledParticle.compileSender();
    }
}
