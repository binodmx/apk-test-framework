# Writing Java unit tests

Make sure you have installed [IntelliJ IDEA](https://www.jetbrains.com/idea/) and [SonarLint](https://www.sonarsource.com/products/sonarlint/) plugin in your computer. Always resolve the SonarLint issues before submitting a commit. Note that [Maven Surefire Plugin](https://maven.apache.org/surefire/maven-surefire-plugin/index.html) and [TestNG](https://testng.org/doc/) framework are used to manage unit tests. [Jacoco](https://www.jacoco.org/jacoco/) plugin is used to generate test reports.

Follow the steps below to write unit tests.
1. Right click on class name --> Show Context Actions --> Create Test.
2. Make sure following properties are set.
    1. Testing library: `TestNG`
    2. Class name: `<className>Test`

![Screenshot from 2022-10-05 13-22-37](https://user-images.githubusercontent.com/36144069/194023075-970997f9-1c22-4727-8921-2f8cace5795a.png)

3. Select methods which need to be tested and click OK.
4. Implement test logic for each `test<methodName>` methods.

# Running Java unit tests

You can use IntelliJ IDEA [Run tool](https://www.jetbrains.com/help/idea/run-tool-window.html), [Maven tool](https://www.jetbrains.com/help/idea/maven-projects-tool-window.html), or Maven CLI commands to run unit tests.

## Using Run tool

Click on play button on required test class or test method to run the unit test.

![image](https://user-images.githubusercontent.com/36144069/194028932-4ee20e5e-b5d6-49d1-9618-5cd57f22e6e6.png)

## Using Maven tool

Open Maven tool window in IntelliJ IDEA and execute `test` phase of the Maven Lifecycle.

![image](https://user-images.githubusercontent.com/36144069/194027289-b0e945e1-0c10-436b-b5f1-ee69ea781088.png)

## Using CLI commands

Go to the relevant root directory of the module and execute following commands as per requirement. For more information refer [Maven surefire plugin usage](https://maven.apache.org/surefire/maven-surefire-plugin/usage.html) or [running a single test](https://maven.apache.org/surefire/maven-surefire-plugin/examples/single-test.html).

1. To run all unit tests: `mvn test`
2. To run specific unit test class: `mvn -Dtest=<testClassName> test`
3. To run specific unit test method: `mvn -Dtest=<testClassName>#<testMethodName> test`
