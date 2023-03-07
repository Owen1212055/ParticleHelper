<h1 style="text-align: center;">ParticleHelper</h1>
<p style="text-align: center;">ParticleHelper is a library that nicely handles the logic for customizing particles for Minecraft Java Edition.</p>

# Documentation

### Gradle
```kt
repositories {
   maven("https://repo.bytecode.space/repository/maven-public/")
}
dependencies {
    implementation("com.owen1212055:particlehelper:1.3.0-SNAPSHOT")
}
```

Allows you to handle particles nicely, accounting for all the weird exceptions.
```java
// Send a single blue note to the player
SingleNoteParticle noteParticle = Particles.NOTE.single()
        .color(Color.fromRGB(0, 0, 255));

// You can even compile the particle to optimize sending to multiple players!
CompiledParticle compiled = noteParticle.compile();

Location location = Bukkit.getWorlds()[0].getSpawnLocation();
for (Player player : Bukkit.getOnlinePlayers()) {
    compiled.send(player, location); // Compiled particles will cache their packet when reusing the same location!
}

// Send a bulk note particle
MultiNoteParticle noteParticle = Particles.NOTE.multi()
        .colorMultiplier(0.5F) // Note we lose the ability to individually modify the particle color, but we can control the multiplier.
        .yOffset(10)
        .count(90);

// Send to a specific player
Player player = Bukkit.getPlayer("bob");
noteParticle.send(player, player.getLocation());

// You can also bundle particles together, allowing for one packet to send
// multiple particles.
com.owen1212055.particlehelper.api.ParticleHelper.bundleParticles(
        Particles.NOTE.single(),
        Particles.SNEEZE.single(),
        Particles.NOTE.single()
).send(event.getPlayer(), event.getPlayer().getLocation());
```


<h1 style="text-align: center;">Need help? Feel free to join my discord for help: https://discord.gg/APaZK9tvkw</h1> 
