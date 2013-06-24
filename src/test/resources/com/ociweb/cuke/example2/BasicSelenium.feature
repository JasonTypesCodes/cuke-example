Feature: Application manages a table of person information.
  As a user
  I want to have a table of people that I have entered
  So that I can refer to it when making important decisions.

  Background:
  	Given I am on the application home page
  
  
  Scenario: Adding a person adds them to the table
  	  And I enter "George" into "First Name"
  	  And I enter "Washington" into "Last Name"
  	  And I enter "67" into "Age"
  	 When I click the Submit button
  	 Then the following entries should be in my table:
  	 | first name | last name  | age |
  	 | George     | Washington | 67  |
  	 
  
  Scenario: Table limits number of visible rows
  	 When I have "25" people in the table
  	 Then my result table should show "10" users.
  	 
  
  Scenario: In tables larger than the base set, user can navigate to the next set.
  	  And I have "15" people in the table
  	 When I click "Next"
  	 Then my result table should show "5" users.
  	 
  
  Scenario: In tables larger than the base set, increasing the number of visible rows shows more rows.
  	  And I have "15" people in the table
  	 When I select "25" as the number of entries to show
  	 Then my result table should show "15" users.
  	 
  
  Scenario: User can sort results by age
  	  And I have input the following entries:
  	   | first name | last name | age |
  	   | John       | Adams     | 61  |
  	   | James      | Garfield  | 48  |
  	   | Gerald     | Ford      | 93  |
  	 When I sort by "Age"
  	 Then the following entries should be in my table:
  	   | first name | last name | age |
  	   | James      | Garfield  | 48  |
  	   | John       | Adams     | 61  |
  	   | Gerald     | Ford      | 93  |
  	  
  	  