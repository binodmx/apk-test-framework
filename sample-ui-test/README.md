Setup and Installation
Clone repo from <<Location>>
Open “UITESTS” from Visual studio code editor
Open terminal from VS code and run “npm ci”

Getting started with test scripting

Folder structure


Package name
Content
Fixture
All test data files goes here
Integration
Test spec files goes here
** you can maintain subfolders based on test categorization 
support/functions
You can define common business functions ehre.
E.g. Logins, MenuNavigation, 
support/pages
Page objects which contains element locators goes here


Process of writing a new Test
Identify the test scenarios 
Create Test spec file in relevant sub folder under Integration folder
Import required page objects to the test spec file
If required page objects not available you can create them under pages folders
If you need new element locators update those in existing page objects
Import required business fucntions

Sample test spec file with page objects and business function

Sample business function


Best practices
Do not hardcode element locators inside test spec files, all locatores should be located in relevant Page Objects
USer available Common Business functions inside you test script
E.g. Menu navigation, Login
Naming conventions
Test (Spec file) name in belo format
<<TestID>>_MeaningfullTestName

Test Execution





Run all test spec files in headless mode
npm run test
Run all test spec files in GUI mode
npm run test:gui
Define the browser
<>  --browser=chrome --headed
Open Cypress 
npx cypress open



