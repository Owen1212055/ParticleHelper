plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("xyz.jpenilla.run-paper") version "2.0.1"
}

group = "com.owen1212055"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")
    implementation(project(":nms", configuration = "reobf"))
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }

    shadowJar {
        dependencies {
            relocate("org.bstats", "com.owen1212055.${rootProject.name}.libs.bstats")
        }
    }

    runServer {
        minecraftVersion("1.19.4")
    }

}