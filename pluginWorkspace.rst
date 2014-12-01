Setting up your Workspace
=========================
This will be moved to the Sponge wiki
=========================

The Sponge maven repository is at http://repo.spongepowered.org/Sponge/maven/.
All sponge artifacts are under the group ID of ``org.spongepowered``.

Artifact IDs are as follows:

- the API: ``spongeapi``
- the forge based implementation: ``sponge``

Sponge plugins can be compiled with `Gradle <http://gradle.org>`__ or `Maven <http://maven.apache.org>`__.

The Sponge team recommends the use of Gradle as use of the Forge team's ForgeGradle plugin can allow testing of Sponge inside Eclipse or Intellij IDEA development environments.

Development builds use the SNAPSHOT system

`Online Javadocs(Temporary link) <http://spongepowered.github.io/SpongeAPI/>`__

Gradle
------

Gradle users place the following in your build.gradle:

.. code-block:: groovy

    repositories {
        mavenCentral()
        maven {
            name 'Sponge maven repo'
            url 'http://repo.spongepowered.org/Sponge/maven'
        }
    }

    dependencies {
        compile "org.spongepowered:spongeapi:1.0"
    }

Maven
-----

Maven users place the following in your pom.xml:

.. code-block:: xml

    <repositories>
        <repository>
            <id>sponge-maven-repo</id>
            <name>Sponge maven repo</name>
            <url>http://repo.spongepowered.org/Sponge/maven</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>org.spongepowered</groupId>
            <artifactId>spongeapi</artifactId>
            <version>1.0</version>
        </dependency>
    </dependencies>
