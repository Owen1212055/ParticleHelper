package com.owen1212055.particlehelper.api.particle.types.vibration;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.simple.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractMultiParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Location;
import org.bukkit.Vibration;
import org.jetbrains.annotations.NotNull;

public class MultiVibrationParticle extends AbstractMultiParticle implements VibrationParticle {

    private Vibration vibration = new Vibration(new Vibration.Destination.BlockDestination(new Location(null, 0, 0, 0)), 0);

    public MultiVibrationParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public @NotNull Vibration getVibration() {
        return this.vibration;
    }

    @Override
    public void setVibration(@NotNull Vibration vibration) {
        this.vibration = vibration;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.data = this.vibration;

        return simpleCompiledParticle.compileSender();
    }
}
