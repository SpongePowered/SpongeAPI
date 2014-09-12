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
* Keep all related changes in a single PR
* Be descriptive, explain the reasoning behind your changes
* Document your code (Javadocs)
* Don't close and reopen a new PR every time you want to make a change to your submission
