plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    maven("https://repo.spongepowered.org/maven")
    jcenter()
}

dependencies {
    implementation("net.minecrell.licenser:net.minecrell.licenser.gradle.plugin:0.4.1")
    implementation(group = "org.spongepowered", name = "spongegradle", version = "0.11.0-SNAPSHOT")
}
