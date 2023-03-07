package com.owen1212055.particlehelper.api.particle.types.dust.transition;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.dust.SingleDustParticleImpl;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.jetbrains.annotations.NotNull;

public class SingleDustTransitionParticle extends SingleDustParticleImpl<SingleDustTransitionParticle> implements TransitionDustParticle<SingleDustTransitionParticle> {

    private Color fade = Color.RED;

    public SingleDustTransitionParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public @NotNull Color fadeColor() {
        return this.fade;
    }

    @Override
    public @NotNull SingleDustTransitionParticle fadeColor(@NotNull Color color) {
        this.fade = color;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.xVelocity;
        simpleCompiledParticle.offsetY = this.yVelocity;
        simpleCompiledParticle.offsetZ = this.zVelocity;
        simpleCompiledParticle.speed = 1; // Keep speed constant
        simpleCompiledParticle.data = new Particle.DustTransition(color, fade, size);

        return simpleCompiledParticle.compileSender();
    }
}
