Feature: Subscribe Feature

  Scenario Outline: Subscribe scenario with differe set of data
    Given user in homepage
    When user click Subscribe email text box
    When user fills the details from given sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on subscribe button
    Then it shows sucess message "<loginResult>"

    Examples: 
      | SheetName | RowNumber | loginResult                |
      | Sheet1    |         0 | Please fill out the fields  |
      | Sheet1    |         1 | Please fill out the fields |
      | Sheet1    |         2 | Thank you for signing up! |
