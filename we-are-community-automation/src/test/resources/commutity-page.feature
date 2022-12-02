Feature: WeAreCommunity tests

  Scenario: Search for Debrecen Java Community
    Given the Main page is loaded
    And the page header should be 'Achieve more with the community'
    And the Cookie disclaimer is closed

    When the search field filled with 'Debrecen Java Community'
    And the Search button is clicked
    Then the 'search' page loaded

  Scenario: Change location in Events pages
    When the Events button is clicked
    Then the 'events' page loaded

    When the Location is clicked
    And the Location input is filled with 'Hungary'
    And 'Hungary' is selected from the list

  Scenario: Change the language
    When the language selector is clicked
    And russian option is selected
    And the page header should be 'Добивайся большего вместе с сообществом'

  Scenario Outline: Signup with invalid password
    When the Login button is clicked
    And the Login page is opened
    And the email field is filled with 'Test@email.com'
    And the Continue button is clicked
    And the user credentials are filled with the followings
      | firstName | lastName |
      | Test      | User     |
    And the '<field>' is filled with '<parameter>'
    Then the '<errorMessage>' error message of the '<field>' field should be shown

    Examples:
      | field    | parameter | errorMessage              |
      | Password | test      | at least 9 characters     |
      | Password | test12345 | at least 1 capital letter |
