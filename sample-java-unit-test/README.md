# Writing Java unit tests

Make sure you have installed IntelliJ IDEA [1] and SonarLint [2] plugin in your computer. Always resolve the SonarLint issues before submitting a commit. TestNG [3] framework is used write unit tests. Follow the steps below when you are writing unit tests.
1. Right click on class name --> Show Context Actions --> Create Test 
2. Make sure following properties are set
  a. Testing library: TestNG
  b. Class name: className + 'Test'
3. Select methods which need to be tested and click OK
4. Implement test logic for each test<methodName> methods




[1] https://www.jetbrains.com/idea/
[2] https://www.sonarsource.com/products/sonarlint/
[3] https://testng.org/doc/
[4] https://www.jacoco.org/jacoco/
