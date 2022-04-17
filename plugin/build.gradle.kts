plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("xyz.jpenilla.run-paper") version "1.0.6"
}

group = "com.owen1212055"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation(project(":api"))
    compileOnly(project(":nms"))

    implementation("org.bstats:bstats-bukkit:3.0.0")
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

        val nmsProject = project(":nms")
        val moveTask = nmsProject.tasks.getByName("moveFiles")

        moveTask.dependsOn(nmsProject.getTasksByName("reobfJar", true))

        finalizedBy(moveTask)
    }

    runServer {
        minecraftVersion("1.18.2")
    }

}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}