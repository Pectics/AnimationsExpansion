plugins {
    kotlin("jvm") version "2.0.21"
    id("com.github.gmazzo.buildconfig") version "4.1.2"
    id("com.gradleup.shadow") version "8.3.0"
}

val projectVersion: String by extra("1.0.0")

group = "me.pectics.papi.expansion"
version = projectVersion

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") {
        name = "spigotmc-repo"
    }
    maven("https://repo.extendedclip.com/releases/") {
        name = "extentedclip-repo"
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.21.8-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.11.6")
    compileOnly(kotlin("stdlib"))
}

kotlin {
    jvmToolchain(21)
}

buildConfig {
    packageName("me.pectics.papi.expansion.animations")
    buildConfigField("String", "VERSION", "\"$projectVersion\"")
}

tasks.build {
    dependsOn(tasks.shadowJar)
}