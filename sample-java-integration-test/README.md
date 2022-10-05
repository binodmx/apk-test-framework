# Writing Java integration tests

# Running Java integration tests

You can use IntelliJ IDEA [Run tool](https://www.jetbrains.com/help/idea/run-tool-window.html), [Maven tool](https://www.jetbrains.com/help/idea/maven-projects-tool-window.html), or Maven CLI commands to run integration tests.

## Using Run tool

Click on play button on required test class or test method to run the integration test.

## Using Maven tool

Open Maven tool window in IntelliJ IDEA and execute `verify` phase of the Maven Lifecycle.

## Using CLI commands

Go to the relevant root directory of the module and execute following commands as per requirement. For more information refer [Maven falesafe plugin usage](https://maven.apache.org/surefire/maven-failsafe-plugin/usage.html) or [running a single test](https://maven.apache.org/surefire/maven-failsafe-plugin/examples/single-test.html).

1. To run all unit tests: `mvn verify`
2. To run specific integration test class: `mvn -Dit.test=<testClassName> verify`
3. To run multiple integration test classes: `mvn -Dit.test=<testClassName1>,<testClassName2> verify`
4. To run specific integration test method: `mvn -Dit.test=<testClassName>#<testMethodName> verify`
