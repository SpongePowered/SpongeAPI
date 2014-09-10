# SpongeAPI [![Build Status](https://api.travis-ci.org/SpongePowered/SpongeAPI.png)](https://travis-ci.org/SpongePowered/SpongeAPI/)

SpongeAPI is the "API" portion of Sponge. It is a set of interfaces that plugins can build against so they can be run on a Sponge-compatible implementation. SpongeAPI cannot be run by itself as it does not implement the game or a server.

**NOTE: THE API IS CURRENTLY A WORK IN PROGRESS.**

Compiling
---------

Use the provided Gradle runtime to compile.

    ./gradlew build

Contributing
------------
Before you edit any code, you will need to setup your workspace first. $EDITOR being what you use to edit the source code:

    ./gradlew $EDITOR

A more detailed explaination can be found in the wiki [Setting up your workspace](https://github.com/SpongePowered/SpongeAPI/wiki/Setting-up-your-Workspace)
	
Make sure your code compiles, passes tests and checkstyle, and has the correct license headers before committing:

    ./gradlew
	
A pre-commit hook is available that automatically checks and applies the license headers. To use it, copy it to .git/hooks

    cp scripts/pre-commit .git/hooks

SpongeAPI is available under the MIT license. The license can be found in LICENSE.txt.

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
