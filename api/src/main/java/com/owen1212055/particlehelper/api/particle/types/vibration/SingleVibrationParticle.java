package com.owen1212055.particlehelper.api.particle.types.vibration;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.AbstractSingleParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Vibration;

public class SingleVibrationParticle extends AbstractSingleParticle implements VibrationParticle {

    private Vibration vibration;

    public SingleVibrationParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public Vibration getVibration() {
        return this.vibration;
    }

    @Override
    public void setVibration(Vibration vibration) {
        this.vibration = vibration;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.data = this.vibration;

        return simpleCompiledParticle.compileSender();
    }
}
