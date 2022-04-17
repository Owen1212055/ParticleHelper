package com.owen1212055.particlehelper.api.particle.types.entityeffect;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.*;

public class SingleEntityEffectParticle extends AbstractSingleParticle implements ColorableParticle {

    private Color color;

    public SingleEntityEffectParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle compiledParticle =  new SimpleCompiledParticle(this);
        compiledParticle.speed = 1; // Leave the color
        compiledParticle.offsetX = color.getRed() / 255F;
        compiledParticle.offsetY = color.getGreen() / 255F;
        compiledParticle.offsetZ = color.getBlue() / 255F;

        return compiledParticle.compileSender();
    }

}
