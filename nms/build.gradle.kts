plugins {
    id("io.papermc.paperweight.userdev")
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "com.owen1212055"
version = parent!!.version

repositories {
    mavenCentral()
}

tasks {
    jar {
        dependsOn(reobfJar)
    }

    reobfJar {
        outputJar.set(layout.buildDirectory.file("libs/particlehelper-${project.version}.jar"))
    }
}

dependencies {
    paperDevBundle("1.19-R0.1-SNAPSHOT")

    implementation(project(":api"))
}