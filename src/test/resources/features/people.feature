Feature: EndToEnd tests

  Scenario: Checking people
    When I get people information
    Then I check at list one of them has name "C-3PO"
    Then I check 1 person with name equals to "Luke Skywalker" has "blue" eyes