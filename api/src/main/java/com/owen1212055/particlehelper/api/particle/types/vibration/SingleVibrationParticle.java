package com.owen1212055.particlehelper.api.particle.types.vibration;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Location;
import org.bukkit.Vibration;
import org.jetbrains.annotations.NotNull;

public class SingleVibrationParticle extends AbstractSingleParticle<SingleVibrationParticle> implements VibrationParticle<SingleVibrationParticle> {

    private Vibration vibration = new Vibration(new Vibration.Destination.BlockDestination(new Location(null, 0, 0, 0)), 0);

    public SingleVibrationParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public @NotNull Vibration vibration() {
        return this.vibration;
    }

    @NotNull
    @Override
    public SingleVibrationParticle vibration(@NotNull Vibration vibration) {
        this.vibration = vibration;
        return this;
    }

    @Override
    public @NotNull CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.data = this.vibration;

        return simpleCompiledParticle.compileSender();
    }
}
