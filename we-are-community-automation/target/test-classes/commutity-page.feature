Feature: WeAreCommunity tests

  Scenario: Search for Debrecen Java Community
    Given the main page is loaded
    And the Cookie disclaimer is closed
    When the search field filled with 'Debrecen Java Community'
    And I click on the search button
    Then the 'search' page loaded

  Scenario: Change location in Events pages
    Given the main page is loaded
    And the Cookie disclaimer is closed
    When I click on the Events button
    Then the 'events' page loaded
    When I click on the Location
    And I fill the Location input with 'Hungary'
    And I select 'Hungary' from the list

  Scenario: Change the language
    Given the main page is loaded
    And the Cookie disclaimer is closed
    When I click on the language selector
    And I click on the russian option

  Scenario: Signup with invalid password
    Given the main page is loaded
    And the Cookie disclaimer is closed
    When I click on the Login button
    And the Login page opened
    And I fill the email field
    And I click on the Continue button
    And I fill the password field with invalid value
    Then the error should be shown

