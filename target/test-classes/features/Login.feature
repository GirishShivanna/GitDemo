Feature: Login into the application

Scenario: Valid login credentials
Given Initialize browser with chrome driver
And Navigate to MercuryTour website
When User provides the "demo1" and "test1"
And click on SignIn button
Then Login should be successfull
And Verify the pageTitle
And Close Browser

Scenario: Valid login credentials
Given Initialize browser with chrome driver
And Navigate to MercuryTour website
When User provides the "demo2" and "test2"
And click on SignIn button
Then Login should not be successfull
And Verify the pageTitle
And Close Browser