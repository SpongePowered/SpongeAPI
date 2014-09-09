# Sponge [![Build Status](https://api.travis-ci.org/SpongePowered/Sponge.png)](https://travis-ci.org/SpongePowered/Sponge/)

Sponge is an implementation of the SpongeAPI for Minecraft Forge.

**NOTE: THIS PROJECT IS CURRENTLY A WORK IN PROGRESS. WE DO NOT RECOMMEND USING IT AT THIS TIME.**

Compiling
---------

First, be sure to initialize the Git submodules:

    git submodule update --init --recursive

Then use the provided Gradle runtime to compile.

    ./gradlew build

Note: This project currently needs a very recent build of Forge. Please see `build.gradle` for the current version/branch requirements.

Contributing
------------

Before doing any major code changes, you probably want to have access to the minecraft source for reference:

    ./gradlew setupDecompWorkspace

Make sure your code compiles, passes tests and checkstyle, and has the correct license headers before committing:

    ./gradlew

A pre-commit hook is available that automatically checks and applies the license headers. To use it, copy it to .git/hooks

    cp scripts/pre-commit .git/hooks

Sponge is available under the MIT license. The license can be found in LICENSE.txt.

Contributions must be licensed under the MIT license.

Pull request guidelines
-----------------

* Read the [Contribution Guidelines](https://docs.google.com/document/d/1483QXESTnQ8iGcnsL6sdgv6JWNm5NqZ50OuZUMpvLB0) document
* Try and keep your PRs to only 1 commit
* Keep all related changes in a single PR
* Be descriptive, explain the reasoning behind your changes
* Document your code (Javadocs)
* Don't close and reopen a new PR every time you want to make a change to your submission

Links
-----

* [Visit our website](http://www.spongepowered.org/)
* [Chat with us (general talk)](https://webchat.esper.net/?channels=sponge)
* [Chat with us (dev talk)](https://webchat.esper.net/?channels=spongedev)
