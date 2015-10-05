SpongeAPI [![Build Status](https://travis-ci.org/SpongePowered/SpongeAPI.svg?branch=master)](https://travis-ci.org/SpongePowered/SpongeAPI)
=============
**Currently not stable and under heavy development!**  
A Minecraft plugin API (not including an implementation). It is licensed under the [MIT License]. 

* [Homepage]
* [Source]
* [Issues]
* [Wiki]
* [Community Chat]: [#sponge on irc.esper.net]
* [Development Chat]: [#spongedev on irc.esper.net]
* [Preparing for Development]
* [Javadocs]

## Prerequisites
* [Java] 8

## Clone
The following steps will ensure your project is cloned properly.  
1. `git clone git@github.com:SpongePowered/SpongeAPI.git`  
2. `cd SpongeAPI`  
3. `cp scripts/pre-commit .git/hooks`

## Building
__Note:__ If you do not have [Gradle] installed then use ./gradlew for Unix systems or Git Bash and gradlew.bat for Windows systems in place of any 'gradle' command.

In order to build SpongeAPI you simply need to run the `gradle` command. You can find the compiled JAR file in `./build/libs` labeled similarly to 'spongeapi-x.x.x-SNAPSHOT.jar'.

## Contributing
Are you a talented programmer looking to contribute some code? We'd love the help!
* Open a pull request with your changes, following our [guidelines](CONTRIBUTING.md).
* Please follow the above guidelines and requirements for your pull request(s) to be accepted.

[Eclipse]: https://www.eclipse.org/
[Gradle]: https://www.gradle.org/
[Homepage]: https://spongepowered.org/
[IntelliJ]: https://www.jetbrains.com/idea/
[Issues]: https://issues.spongepowered.org/
[Wiki]: https://github.com/SpongePowered/SpongeAPI/wiki/
[Java]: http://java.oracle.com/
[Source]: https://github.com/SpongePowered/SpongeAPI/
[MIT License]: https://www.tldrlegal.com/license/mit-license
[Community Chat]: https://webchat.esper.net/?channels=sponge
[Development Chat]: https://webchat.esper.net/?channels=spongedev
[Preparing for Development]: https://docs.spongepowered.org/en/preparing/
[#sponge on irc.esper.net]: irc://irc.esper.net/#sponge
[Development Chat]: https://webchat.esper.net/?channels=spongedev
[#spongedev on irc.esper.net]: irc://irc.esper.net/#spongedev
[Preparing for Development]: https://docs.spongepowered.org/en/preparing/
[Javadocs]: https://jd.spongepowered.org
