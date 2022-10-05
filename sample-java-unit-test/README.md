# Writing Java unit tests

Make sure you have installed [IntelliJ IDEA](https://www.jetbrains.com/idea/) and [SonarLint](https://www.sonarsource.com/products/sonarlint/) plugin in your computer. Always resolve the SonarLint issues before submitting a commit. Note that [TestNG](https://testng.org/doc/) framework is used to write unit tests and [Jacoco](https://www.jacoco.org/jacoco/) is used to generate test reports.

Follow the steps below to write unit tests.
1. Right click on class name --> Show Context Actions --> Create Test 
2. Make sure following properties are set
    1. Testing library: `TestNG`
    2. Class name: className + 'Test'
3. Select methods which need to be tested and click OK
4. Implement test logic for each test<methodName> methods
