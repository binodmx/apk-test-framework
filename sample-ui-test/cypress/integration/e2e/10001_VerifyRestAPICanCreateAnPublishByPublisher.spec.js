/*
 * Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
import Login from "../../support/functions/Login";
import PublisherMenu from "../../support/functions/PublisherMenu";
import CreateRestAPIPage from "../../support/pages/publisher/CreateRestAPIPage";
import ApisHomePage from "../../support/pages/publisher/ApisHomePage";
import APIBasicInfoPage from "../../support/pages/publisher/APIBasicInfoPage";
import DeploymentsPage from "../../support/pages/publisher/DeploymentsPage";
import LifecyclePage from "../../support/pages/publisher/LifecyclePage";

describe("10001 : Verify Rest API can created and publish successfully by publisher", () => {
    it("Create and publish Rest API", () => {
       Login.loginToPublisher('admin','admin') 

       CreateRestAPIPage.visitAPIsPage()
       CreateRestAPIPage.getAPINameTextBox().type("PizzaShack")
       CreateRestAPIPage.getAPIContextTextBox().type("/pizzashack")
       CreateRestAPIPage.getAPIVersionTextBox().type("1.0.0")
       CreateRestAPIPage.getAPIEndpointTextBox().type("https://am.wso2.com/am/sample/pizzashack/v1/api/")
       CreateRestAPIPage.getAPICreateButton().click()
       cy.contains("API created successfully")

       PublisherMenu.goToBasicInfoByMenu()
       cy.wait(5000)

       ApisHomePage.getApiNameVersionH1().should("have.text","PizzaShack :1.0.0")
       ApisHomePage.getApiStateDiv().should("have.text","CREATED")

       APIBasicInfoPage.getTagsTextBox().type("pizza").type('{enter}')
       APIBasicInfoPage.getTagsTextBox().type("order").type('{enter}')
       APIBasicInfoPage.getTagsTextBox().type("pizza-menu").type('{enter}')
       APIBasicInfoPage.getDefaultVersionNoRadio().click()

       APIBasicInfoPage.getSaveButton().click()
       cy.contains("PizzaShack API updated successfully")

       PublisherMenu.goToDeploymentsByMenu()
       DeploymentsPage.getDeployButton().click()
       cy.contains("Revision Created Successfully")
       cy.contains("Revision Deployed Successfully")

       PublisherMenu.goToLifecycleByMenu()
       LifecyclePage.getPublishButton().click()
       cy.contains("Lifecycle state updated successfully")
       ApisHomePage.getApiStateDiv().contains("PUBLISHED")

    });
})