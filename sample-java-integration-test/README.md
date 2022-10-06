# Writing Java integration tests

Make sure you have installed [IntelliJ IDEA](https://www.jetbrains.com/idea/) and [SonarLint](https://www.sonarsource.com/products/sonarlint/) plugin in your computer. Always resolve the SonarLint issues before submitting a commit. Note that [Maven Failsafe Plugin](https://maven.apache.org/surefire/maven-failsafe-plugin/index.html) and [TestNG](https://testng.org/doc/) framework are used to manage integration tests.

### Adding resource files

Resource files (.json, .xml, .yml, .toml, .jar, .jks, .cer, ...) should be added to 
`src/test/resources/<subDirectoryName>` directory with a proper file name that describes the resource file. 

- Here, `subDirectoryName` is the last name of the test package name. For example, if the package name is 
`org.example.it.restapi` then the `subDirectoryName` is `restapi`.
- However, If the resource file is used different test packages, it should be added to `src/test/resources/common` 
directory.

### Mocking

- REST APIs: https://rest-assured.io/
- 

# Running Java integration tests

You can use IntelliJ IDEA [Run tool](https://www.jetbrains.com/help/idea/run-tool-window.html), [Maven tool](https://www.jetbrains.com/help/idea/maven-projects-tool-window.html), or Maven CLI commands to run integration tests.

## Using Run tool

Click on play button on required test class or test method to run the integration test.

## Using Maven tool

Open Maven tool window in IntelliJ IDEA and execute `verify` phase of the Maven Lifecycle.

![image](https://user-images.githubusercontent.com/36144069/194096513-25e58241-ebcb-433d-a99c-71af36dfb3d4.png)

## Using CLI commands

Go to the relevant root directory of the module and execute following commands as per requirement. For more information refer [Maven failsafe plugin usage](https://maven.apache.org/surefire/maven-failsafe-plugin/usage.html) or [running a single test](https://maven.apache.org/surefire/maven-failsafe-plugin/examples/single-test.html).

1. To run all unit tests: `mvn verify`
2. To run specific integration test class: `mvn -Dit.test=<testClassName> verify`
3. To run multiple integration test classes: `mvn -Dit.test=<testClassName1>,<testClassName2> verify`
4. To run specific integration test method: `mvn -Dit.test=<testClassName>#<testMethodName> verify`
