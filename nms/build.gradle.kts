import java.nio.file.Files
import java.nio.file.StandardCopyOption

plugins {
    java
    id("io.papermc.paperweight.userdev") version "1.3.5"
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "com.owen1212055"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    paperDevBundle("1.19-R0.1-SNAPSHOT")

    compileOnly(project(":api")) {
        isTransitive = false
    }

}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

val moveJars by tasks.register("moveFiles", DefaultTask::class)

moveJars.doFirst {

    val file = tasks.named<io.papermc.paperweight.tasks.RemapJar>("reobfJar").flatMap { task -> task.outputJar }
        .get().asFile.toPath()

    if (Files.exists(file)) {
        Files.move(
            file,
            project(":plugin").projectDir.toPath().resolve("src/main/resources/nms-1.0.jar"),
            StandardCopyOption.REPLACE_EXISTING
        )
    }
}