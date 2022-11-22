Feature: WeAreCommunity tests

  Scenario: Search for Debrecen Java Community
    Given the main page is loaded
    When the search field filled with 'Debrecen Java Community'
    And I click on the search button
    Then the required page loaded