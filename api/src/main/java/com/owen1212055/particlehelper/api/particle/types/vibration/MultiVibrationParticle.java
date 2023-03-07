package com.owen1212055.particlehelper.api.particle.types.vibration;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractMultiParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Location;
import org.bukkit.Vibration;
import org.jetbrains.annotations.NotNull;

public class MultiVibrationParticle extends AbstractMultiParticle<MultiVibrationParticle> implements VibrationParticle<MultiVibrationParticle> {

    private Vibration vibration = new Vibration(new Vibration.Destination.BlockDestination(new Location(null, 0, 0, 0)), 0);

    public MultiVibrationParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public @NotNull Vibration vibration() {
        return this.vibration;
    }

    @NotNull
    @Override
    public MultiVibrationParticle vibration(@NotNull Vibration vibration) {
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
