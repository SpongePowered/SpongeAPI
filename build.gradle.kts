import net.ltgt.gradle.errorprone.errorprone
import org.jetbrains.gradle.ext.delegateActions
import org.jetbrains.gradle.ext.settings
import org.jetbrains.gradle.ext.taskTriggers

buildscript {
    dependencies {
        classpath(libs.spoon) // bump for EIG
    }
}

plugins {
    eclipse
    alias(libs.plugins.spongeGradle.convention)
    alias(libs.plugins.indra.checkstyle)
    alias(libs.plugins.indra.crossdoc)
    alias(libs.plugins.indra.publishing)
    alias(libs.plugins.indra.publishing.sonatype)
    alias(libs.plugins.eventImplGen)
    alias(libs.plugins.ideaExt)
    alias(libs.plugins.errorprone)
    alias(libs.plugins.nexusPublish)
}

val javaTarget: String by project
val ap by sourceSets.registering {
    compileClasspath += sourceSets.main.get().compileClasspath + sourceSets.main.get().output
}

configurations {
    sequenceOf(apiElements, runtimeElements).forEach {
       it.configure {
           exclude(group = "org.jetbrains",  module = "annotations")
       }
    }
}

// Project dependencies
dependencies {
    // Directly tied to what's available from Minecraft
    api(libs.log4j.api)
    api(libs.gson)

    // Adventure
    api(platform(libs.adventure.bom))
    api(libs.adventure.api)
    api(libs.adventure.textSerializer.gson) {
        exclude(group = "com.google.code.gson", module = "gson")
        exclude(group = "net.kyori", module = "adventure-api")
    }
    api(libs.adventure.textSerializer.legacy) {
        exclude(group = "net.kyori", module = "adventure-api")
    }
    api(libs.adventure.textSerializer.plain) {
        exclude(group = "net.kyori", module = "adventure-api")
    }
    api(libs.adventure.minimessage) {
        exclude(group = "net.kyori", module = "adventure-api")
    }

    // Dependency injection
    api(libs.guice) {
        exclude(group = "com.google.code.findbugs", module = "jsr305") // We don't want to use jsr305, use checkerframework
        exclude(group = "javax.inject", module = "javax.inject")
        exclude(group = "com.google.guava", module = "guava") // We use an older version than Guice does
        exclude(group = "org.ow2.asm", module = "asm")
    }

    // High performance cache + guava - shaded guava
    api(libs.caffeine) {
        exclude(group = "org.checkerframework", module = "checker-qual")
        exclude(group = "com.google.errorprone", module = "error_prone_annotations")
        exclude(group = "org.junit", module = "junit-bom")
        exclude(group = "org.yaml", module = "snakeyaml")
        exclude(group = "com.fasterxml.jackson", module = "jackson-bom")
        exclude(group = "org.ow2.asm", module = "asm-bom")
    }

    // Plugin spi, includes plugin-meta
    api(libs.pluginSpi) {
        exclude(group = "org.checkerframework", module = "checker-qual")
        exclude(group = "com.google.code.gson", module = "gson")
        exclude(group = "org.apache.logging.log4j", module = "log4j-api")
    }

    // Configurate
    api(platform(libs.configurate.bom))
    api(libs.configurate.core) {
        exclude(group = "org.checkerframework", module = "checker-qual") // We use our own version
        exclude(group = "com.google.errorprone", module = "error_prone_annotations")
    }
    api(libs.configurate.hocon) {
        exclude(group = "org.spongepowered", module = "configurate-core")
        exclude(group = "org.checkerframework", module = "checker-qual")
        exclude(group = "com.google.errorprone", module = "error_prone_annotations")

    }
    api(libs.configurate.gson) {
        exclude(group = "org.spongepowered", module = "configurate-core")
        exclude(group = "com.google.code.gson", module = "gson") // We have the same version technically, but use the gson we provide.
        exclude(group = "org.checkerframework", module = "checker-qual")
        exclude(group = "com.google.errorprone", module = "error_prone_annotations")
    }
    api(libs.configurate.yaml) {
        exclude(group = "org.spongepowered", module = "configurate-core")
        exclude(group = "org.checkerframework", module = "checker-qual")
        exclude(group = "com.google.errorprone", module = "error_prone_annotations")
    }
    api(libs.configurate.extraGuice) {
        exclude(group = "com.google.inject", module = "guice")
        exclude(group = "com.google.errorprone", module = "error_prone_annotations")
    }

    // Compile-time static analysis
    compileOnly(libs.errorprone.annotations)
    errorprone(libs.errorprone)

    // Math library
    api(libs.math) {
        exclude(group = "com.google.errorprone", module = "error_prone_annotations")
    }

    compileOnlyApi(libs.checkerQual)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.api)
    testImplementation(libs.junit.params)
    testRuntimeOnly(libs.junit.engine)
    testRuntimeOnly(libs.junit.launcher)
    testImplementation(libs.mockito)
}

tasks {
    genEventImpl {
        sourceCompatibility = "17" // TODO use javaTarget here
        destinationDirectory = project.layout.buildDirectory.dir("generated/event-factory")

        outputFactory = "org.spongepowered.api.event.SpongeEventFactory"
        include("org/spongepowered/api/event/*/**/*")
        exclude("org/spongepowered/api/event/action/InteractEvent.java")
        exclude("org/spongepowered/api/event/cause/")
        exclude("org/spongepowered/api/event/entity/AffectEntityEvent.java")
        exclude("org/spongepowered/api/event/filter/")
        exclude("org/spongepowered/api/event/impl/")
        exclude("org/spongepowered/api/event/lifecycle/ProvideServiceEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterBuilderEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterRegistryEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterRegistryValueEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterCommandEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterFactoryEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterWorldEvent.java")
        inclusiveAnnotations = setOf("org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod")
        exclusiveAnnotations = setOf("org.spongepowered.api.util.annotation.eventgen.NoFactoryMethod")
    }

    jar {
        from(ap.get().output)
        manifest {
            attributes("Main-Class" to "org.spongepowered.api.util.InformativeMain")
            attributes("Specification-Vendor" to "SpongePowered")
            attributes("Specification-Title" to "SpongeAPI")
            attributes("Specification-Version" to project.version)
            if (!indraGit.isPresent) {
              throw InvalidUserDataException("SpongeAPI must be built as a Git checkout, rather than through a zip/tar export")
            }
            indraGit.applyVcsInformationToManifest(this)
        }
    }

    withType(JavaCompile::class).configureEach {
        options.apply {
            compilerArgs.addAll(listOf("-Xlint:-path"))
            isDeprecation = false
        }
    }

    javadoc {
        options {
            (this as? StandardJavadocDocletOptions)?.apply {
                links(
                    "https://logging.apache.org/log4j/2.x/javadoc/log4j-api/",
                    "https://google.github.io/guice/api-docs/${libs.versions.guice.get()}/javadoc/",
                    "https://configurate.aoeu.xyz/${libs.versions.configurate.get()}/apidocs/",
                    "https://www.javadoc.io/doc/com.google.code.gson/gson/${libs.versions.gson.get()}/",
                    "https://jd.spongepowered.org/math/${libs.versions.math.get()}"
                )
                sequenceOf("api", "key", "text-serializer-gson", "text-serializer-legacy", "text-serializer-plain").forEach {
                    links("https://jd.advntr.dev/$it/${libs.versions.adventure.get()}/")
                }
                addBooleanOption("quiet", true)
            }
        }
    }

    withType(JavaCompile::class).configureEach {
        options.errorprone {
            disable("FutureReturnValueIgnored") // this check doesn't handle CompletableFuture properly
            disable("EqualsGetClass") // conflicts with IntelliJ defaults
            disable("MissingSummary") // TODO: Re-enable this check once Javadoc is in a better state
        }
    }

//
//    val shadowJar by registering(ShadowJar::class) {
//        archiveClassifier.set("shaded")
//        from(ap.get().output)
//
//    }
}

idea {
    if (project != null) {
        project.settings.run {
            delegateActions {
                delegateBuildRunToGradle = false
                testRunner = org.jetbrains.gradle.ext.ActionDelegationConfig.TestRunner.PLATFORM
            }
            taskTriggers {
                beforeBuild(tasks.genEventImpl)
            }
        }
    }
}

eclipse {
    synchronizationTasks(tasks.genEventImpl)
}

val organization: String by project
val projectUrl: String by project
val projectDescription: String by project

spongeConvention {
    repository("SpongeAPI") {
        ci(true)
        publishing(true)
    }
    mitLicense()

    licenseParameters {
        this["name"] = "SpongeAPI"
        this["organization"] = organization
        this["url"] = projectUrl
    }
}

indra {
    javaVersions {
        target(javaTarget.toInt())
    }
    checkstyle(libs.versions.checkstyle.get())

    configurePublications {
        artifactId = project.name.lowercase()
        pom {
            this.url.set(projectUrl)
            this.description.set(projectDescription)
        }
    }
}

indraCrossdoc {
    baseUrl(providers.gradleProperty("javadocPublishRoot"))
    nameBasedDocumentationUrlProvider {
        lowercaseProjectName.set(true)
    }
}

spotless {
    java {
        toggleOffOn("@formatter:off", "@formatter:on")
        endWithNewline()
        indentWithSpaces(4)
        trimTrailingWhitespace()
        formatAnnotations()
        removeUnusedImports()
        importOrderFile(rootProject.file("extra/eclipse/sponge_eclipse.importorder"))
    }
    kotlinGradle {
        endWithNewline()
        indentWithSpaces(4)
        trimTrailingWhitespace()
    }
}
