SpongeAPI ![Build Status](https://github.com/SpongePowered/SpongeAPI/actions/workflows/ci.yaml/badge.svg?branch=api-10)
=============
A mature Minecraft plugin API (not including an implementation), licensed under the [MIT License]. 

* [Homepage]
* [Source]
* [Issues]
* [Documentation]
* [Preparing for Development]
* [Javadocs]
* [Discord] `#plugins`

## Prerequisites
* [Java] 17

## Clone
The following steps will ensure your project is cloned properly.  
1. `git clone https://github.com/SpongePowered/SpongeAPI.git`  
2. `cd SpongeAPI`  
3. `cp scripts/pre-commit .git/hooks`

## Building
__Note:__ If you do not have [Gradle] installed then use ./gradlew for Unix systems or Git Bash and gradlew.bat for Windows systems in place of any 'gradle' command.

In order to build SpongeAPI you simply need to run the `gradle` command. You can find the compiled JAR file in `./build/libs` labeled similarly to 'spongeapi-x.x.x-SNAPSHOT.jar'.

Sponge will use a javac version of *at least* 17. If an older JDK is used to launch Gradle, JDK 17 will be downloaded automatically.

## Contributing
Are you a talented programmer looking to contribute some code? We'd love the help!
* Open a pull request with your changes, following our [guidelines](CONTRIBUTING.md).
* Please follow the above guidelines and requirements for your pull request(s) to be accepted.

[Eclipse]: https://www.eclipse.org/
[Gradle]: https://www.gradle.org/
[Homepage]: https://spongepowered.org/
[IntelliJ]: https://www.jetbrains.com/idea/
[Issues]: https://github.com/SpongePowered/SpongeAPI/issues
[Documentation]: https://docs.spongepowered.org/
[Java]: https://adoptium.net/temurin/releases/
[Source]: https://github.com/SpongePowered/SpongeAPI/
[MIT License]: https://www.tldrlegal.com/license/mit-license
[Discord]: https://discord.gg/sponge
[Preparing for Development]: https://docs.spongepowered.org/stable/en/preparing/
[Javadocs]: https://jd.spongepowered.org
