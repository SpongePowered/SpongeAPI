plugins {
    `kotlin-dsl`

}
repositories {
    mavenCentral()
    gradlePluginPortal()
    jcenter()
}
dependencies {
    compile("net.minecrell.licenser:net.minecrell.licenser.gradle.plugin:0.4.1")
    compile("com.github.jengelman.gradle.plugins:shadow:5.0.0")
    compile("org.spongepowered.plugin:org.spongepowered.plugin.gradle.plugin:0.8.1")
}
kotlinDslPluginOptions {
    experimentalWarning.set(false)
}