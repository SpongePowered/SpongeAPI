import net.ltgt.gradle.errorprone.errorprone

buildscript {
    dependencies {
        classpath("fr.inria.gforge.spoon:spoon-core:10.2.0") // bump for EIG
    }
}

plugins {
    eclipse
    id("org.spongepowered.gradle.sponge.dev")
    id("net.kyori.indra.checkstyle")
    id("net.kyori.indra.crossdoc")
    id("net.kyori.indra.publishing")
    id("net.kyori.indra.publishing.sonatype")
    id("org.spongepowered.gradle.event-impl-gen")
    id("org.jetbrains.gradle.plugin.idea-ext")
    id("net.ltgt.errorprone")
}

repositories {
    maven("https://repo.spongepowered.org/repository/maven-public/") {
        name = "sponge"
    }
}

val ap by sourceSets.registering {
    compileClasspath += sourceSets.main.get().compileClasspath + sourceSets.main.get().output
}

// Project dependencies
val adventureVersion: String by project
val configurateVersion: String by project
val gsonVersion: String by project
val log4jVersion: String by project
val mathVersion: String by project
dependencies {
    val caffeineVersion: String by project
    val errorproneVersion: String by project
    val junitVersion: String by project
    val mockitoVersion: String by project
    val pluginSpiVersion: String by project
    val checkerVersion: String by project

    // Directly tied to what's available from Minecraft
    api("org.apache.logging.log4j:log4j-api:$log4jVersion")
    api("com.google.code.gson:gson:$gsonVersion")

    // Adventure
    api(platform("net.kyori:adventure-bom:$adventureVersion"))
    api("net.kyori:adventure-api") {
        exclude(group = "org.jetbrains", module = "annotations")
    }
    api("net.kyori:adventure-text-serializer-gson") {
        exclude(group = "com.google.code.gson", module = "gson")
        exclude(group = "net.kyori", module = "adventure-api")
    }
    api("net.kyori:adventure-text-serializer-legacy") {
        exclude(group = "net.kyori", module = "adventure-api")
    }
    api("net.kyori:adventure-text-serializer-plain") {
        exclude(group = "net.kyori", module = "adventure-api")
    }
    api("net.kyori:adventure-text-minimessage") {
        exclude(group = "net.kyori", module = "adventure-api")
    }

    // Dependency injection
    api("com.google.inject:guice:5.0.1") {
        exclude(group = "com.google.code.findbugs", module = "jsr305") // We don't want to use jsr305, use checkerframework
        exclude(group = "javax.inject", module = "javax.inject")
        exclude(group = "com.google.guava", module = "guava") // We use an older version than Guice does
        exclude(group = "org.ow2.asm", module = "asm")
    }

    // High performance cache + guava - shaded guava
    api("com.github.ben-manes.caffeine:caffeine:$caffeineVersion") {
        exclude(group = "org.checkerframework", module = "checker-qual")
        exclude(group = "com.google.errorprone", module = "error_prone_annotations")
        exclude(group = "org.junit", module = "junit-bom")
        exclude(group = "org.yaml", module = "snakeyaml")
        exclude(group = "com.fasterxml.jackson", module = "jackson-bom")
        exclude(group = "org.ow2.asm", module = "asm-bom")
    }

    // Plugin spi, includes plugin-meta
    api("org.spongepowered:plugin-spi:$pluginSpiVersion") {
        exclude(group = "org.checkerframework", module = "checker-qual")
        exclude(group = "com.google.code.gson", module = "gson")
        exclude(group = "org.apache.logging.log4j", module = "log4j-api")
    }

    // Configurate
    api(platform("org.spongepowered:configurate-bom:$configurateVersion"))
    api("org.spongepowered:configurate-core") {
        exclude(group = "org.checkerframework", module = "checker-qual") // We use our own version
    }
    api("org.spongepowered:configurate-hocon") {
        exclude(group = "org.spongepowered", module = "configurate-core")
        exclude(group = "org.checkerframework", module = "checker-qual")

    }
    api("org.spongepowered:configurate-gson") {
        exclude(group = "org.spongepowered", module = "configurate-core")
        exclude(group = "com.google.code.gson", module = "gson") // We have the same version technically, but use the gson we provide.
        exclude(group = "org.checkerframework", module = "checker-qual")
    }
    api("org.spongepowered:configurate-yaml") {
        exclude(group = "org.spongepowered", module = "configurate-core")
        exclude(group = "org.checkerframework", module = "checker-qual")
    }
    api("org.spongepowered:configurate-extra-guice") {
        exclude(group = "com.google.inject", module = "guice")
    }

    // Compile-time static analysis
    compileOnly("com.google.errorprone:error_prone_annotations:$errorproneVersion")
    errorprone("com.google.errorprone:error_prone_core:$errorproneVersion")

    // Math library
    api("org.spongepowered:math:$mathVersion") {
        exclude(group = "com.google.errorprone", module = "error_prone_annotations")
    }

    compileOnlyApi("org.checkerframework:checker-qual:$checkerVersion")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
}

tasks {
    genEventImpl {
        sourceCompatibility = "16"
        destinationDir = project.layout.buildDirectory.dir("generated/event-factory").get().asFile

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
                    "https://logging.apache.org/log4j/log4j-$log4jVersion/log4j-api/apidocs/",
                    "https://google.github.io/guice/api-docs/5.0.1/javadoc/",
                    "https://configurate.aoeu.xyz/$configurateVersion/apidocs/",
                    "https://www.javadoc.io/doc/com.google.code.gson/gson/$gsonVersion/",
                    "https://jd.spongepowered.org/math/$mathVersion"
                )
                sequenceOf("api", "key", "text-serializer-gson", "text-serializer-legacy", "text-serializer-plain").forEach {
                    links("https://jd.advntr.dev/$it/$adventureVersion/")
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
        (project as ExtensionAware).extensions["settings"].run {
            require(this is ExtensionAware)

            this.extensions.getByType(org.jetbrains.gradle.ext.ActionDelegationConfig::class).run {
                delegateBuildRunToGradle = false
                testRunner = org.jetbrains.gradle.ext.ActionDelegationConfig.TestRunner.PLATFORM
            }
            this.extensions.getByType(org.jetbrains.gradle.ext.TaskTriggersConfig::class).run {
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
    val checkstyleVersion: String by project

    javaVersions {
        target(17)
    }
    checkstyle(checkstyleVersion)

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
