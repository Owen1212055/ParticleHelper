plugins {
    `java-library`
}

group = "com.owen1212055"
version = parent!!.version

repositories {
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19-R0.1-SNAPSHOT")
}

java {
    withJavadocJar()
    withSourcesJar()
}

tasks.jar {
    classifier = "api"
}