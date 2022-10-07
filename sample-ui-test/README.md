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
