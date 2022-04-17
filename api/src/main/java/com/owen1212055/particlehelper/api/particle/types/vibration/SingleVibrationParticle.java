package com.owen1212055.particlehelper.api.particle.types.vibration;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.*;

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
