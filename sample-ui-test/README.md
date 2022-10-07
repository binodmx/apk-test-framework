# Setup and Installation
1. Clone repo
2. Open “UITESTS” from Visual studio code editor
3. Open terminal from VS code and run “npm ci”

# Getting started with test scripting

## Folder structure
<<Image>>
  
| Package name  | Content |
| ------------- | ------------- |
| Fixture  | All test data files goes here  |
| Integration  | Test spec files goes here (you can maintain subfolders based on test categorization)  |
| support/functions  | You can define common business functions here .E.g. Logins, MenuNavigation,|
| support/pages  | Page objects which contains element locators goes here  |
  
## Process of writing a new Test
1. Identify the test scenarios 
2. Create Test spec file in relevant sub folder under Integration folder
3. Import required page objects to the test spec file
    a. If required page objects not available you can create them under pages folders
    b. If you need new element locators update those in existing page objects
4. Import required business fucntions

  Sample test spec file with page objects and business function
  <image>
  Sample business function
  <image>
    
## Best practices
- Do not hardcode element locators inside test spec files, all locatores should be located in relevant Page Objects
- USer available Common Business functions inside you test script
 -- E.g. Menu navigation, Login
- Naming conventions
  -- Test (Spec file) name in belo format
  --- <<TestID>>_MeaningfullTestName
    
# Test Execution
| Package name  | Content |
| ------------- | ------------- |
| Run all test spec files in headless mode  | npm run test  |
| Run all test spec files in GUI mode  | npm run test:gui|
| Define the browser  | <>  --browser=chrome --headed|
| Open Cypress   | npx cypress open |
