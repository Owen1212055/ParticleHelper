plugins {
    java
    `java-library`
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "com.owen1212055"

repositories {
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnlyApi("io.papermc.paper:paper-api:1.19-R0.1-SNAPSHOT")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}