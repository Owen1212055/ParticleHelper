plugins {
    java
    id("maven-publish")
    id("io.papermc.paperweight.userdev") version "1.5.2" apply false
}

group = "com.owen1212055"
version = "1.5.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

subprojects {
    apply(plugin = "java")
    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            evaluationDependsOn(":api")
            evaluationDependsOn(":nms")

            groupId = group as String
            artifactId = "particlehelper"
            from(project(":api").components["java"])
            artifact((project(":nms").tasks["reobfJar"] as io.papermc.paperweight.tasks.RemapJar).outputJar)
        }

        tasks.withType<GenerateModuleMetadata> {
            enabled = false
        }
    }

    repositories {
        maven {
            name = "bytecodespace"

            val releasesRepoUrl = uri("https://repo.bytecode.space/repository/maven-releases/")
            val snapshotsRepoUrl = uri("https://repo.bytecode.space/repository/maven-snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl

            credentials(PasswordCredentials::class)
        }
    }
}