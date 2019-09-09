plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    jcenter()
}

dependencies {
    implementation("net.minecrell.licenser:net.minecrell.licenser.gradle.plugin:0.4.1")
    implementation(group = "org.spongepowered", name = "SpongeGradle", version = "0.11.0-SNAPSHOT")
}
