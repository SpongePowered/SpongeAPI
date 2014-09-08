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

    ./gradlew build
    ./gradlew

A pre-commit hook is available that automatically checks and applies the license headers. To use it, copy it to .git/hooks

    cp scripts/pre-commit .git/hooks

Sponge is available under the MIT license. The license can be found in LICENSE.txt.

Contributions must be licensed under the MIT license.

Links
-----

* [Visit our website](http://www.spongepowered.org/)
