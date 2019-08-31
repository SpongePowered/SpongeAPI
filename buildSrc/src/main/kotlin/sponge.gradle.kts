import net.minecrell.gradle.licenser.LicenseExtension
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.plugins.ide.idea.model.IdeaModel

plugins {
    `java-library`
    checkstyle
    eclipse
    idea
    // super hack, because the plugins are declared and defined in the project that
    // is applying this plugin, we can reference them by id here, otherwise, if the
    // project is not declaring them (with versions), they will not be resolvable in
    // this buildscript.
    id(Plugins.licenser)
    id(Plugins.shadow)
    id(Plugins.spongeGradleId)
    id(Plugins.deploy)

}

group = SpongeAPI.group
val base = project.convention.getPlugin(BasePluginConvention::class)
base.archivesBaseName = project.name.toLowerCase()

repositories {
    mavenCentral()
    maven(Repo.sponge)
}

defaultTasks("licenseFormat", "build")


dependencies {
    "testImplementation"(Libs.Test.junit)
    "testImplementation"(Libs.Test.hamcrest)
    "testImplementation"(Libs.Test.mockito)
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType(JavaCompile::class) {
    options.compilerArgs + listOf("-Xlint:all", "-Xlint:-path", "-parameters")
    options.isDeprecation = true
    options.encoding = "UTF-8"
}

tasks {
    val wrapper by existing(Wrapper::class) {
        gradleVersion = SpongeAPI.project!!.gradle.gradleVersion
    }
    val test by existing(Test::class) {
        testLogging {
            exceptionFormat = TestExceptionFormat.FULL // Always print full stack trace if something goes wrong in unit testing
            showStandardStreams = true
        }
    }

    val jar by existing(Jar::class) {
        manifest {
            attributes(
                    "Specification-Title" to SpongeAPI.name,
                    "Specification-Version" to SpongeAPI.version,
                    "Specification-Vendor" to SpongeAPI.organization,
                    "Created-By" to "${System.getProperty("java.version")} ${System.getProperty("java.vendor")} "
            )
            SpongeAPI.`git-commit`?.let { attributes(mapOf("Git-Commit" to it)) }
            SpongeAPI.`git-branch`?.let { attributes(mapOf("Git-Branch" to it)) }
        }
    }

    val javadoc by existing(Javadoc::class) {
        options {
            encoding = "UTF-8"
            charset("UTF-8")
            // We have to do a safe check because we might end up at some point with some
            // doclet that doesn't use the standard javadoc options.
            if (this is StandardJavadocDocletOptions) {
                links(
                        "http://www.slf4j.org/apidocs/",
                        "https://google.github.io/guava/releases/21.0/api/docs/",
                        "https://google.github.io/guice/api-docs/4.1/javadoc/",
                        "https://zml2008.github.io/configurate/configurate-core/apidocs/",
                        "https://zml2008.github.io/configurate/configurate-hocon/apidocs/",
                        "https://flow.github.io/math/",
                        "https://flow.github.io/noise/",
                        "http://asm.ow2.org/asm50/javadoc/user/",
                        "https://docs.oracle.com/javase/8/docs/api/"
                )
                addStringOption("-Xdoclint:none", "-quiet")
            }


        }
    }
    val javadocJar by registering(Jar::class) {
        dependsOn(javadoc)
        archiveClassifier.set("javadoc")
        from(javadoc)
    }

    val checkstyle by registering(Checkstyle::class) {
        // Disable checkstyle by default (won't run unless 'checkstyle' is explicitly invoked)
        dependsOn(tasks.withType(Checkstyle::class))
    }
}

// Due to this being a plugin in buildSrc, it doesn't
// get the same treatment as root build.gradle.kts, so the
// generated accessors for things like `license` are not available
// only cases that are are built in are strictly from Gradle API

configure<LicenseExtension> {
    newLine = false
    (this as ExtensionAware).extra.apply {
        this["name"] = project.name
        this["organization"] = SpongeAPI.organization
        this["url"] = SpongeAPI.url
    }
    include("**/*.java")
    afterEvaluate {
        header = SpongeAPI.project!!.file("HEADER.txt")
    }

}

afterEvaluate {
    // Fail if one file is included several times
    tasks.withType(AbstractArchiveTask::class) {
        if (duplicatesStrategy == DuplicatesStrategy.INCLUDE) {
            duplicatesStrategy = DuplicatesStrategy.FAIL
        }
    }
}

configure<CheckstyleExtension> {
    toolVersion = "8.7"
    afterEvaluate {
        configFile = SpongeAPI.project!!.file("checkstyle.xml")
        configProperties = mapOf(
                "basedir" to project.projectDir,
                "suppressions" to project.file("checkstyle-suppressions.xml"),
                "severity" to "warning"
        )
    }
}

// Disable checkstyle by default (won't run unless 'checkstyle' is explicitly invoked)
gradle.taskGraph.whenReady {
    if (!this.allTasks.contains(tasks.findByName("checkstyle"))) {
        this.allTasks
                .filter { it.name.startsWith("checkstyle") }
                .forEach { it.enabled = false }
    }
}

configure<IdeaModel> {
    module.inheritOutputDirs = true
}