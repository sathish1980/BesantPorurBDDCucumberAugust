Feature: To validate MakeMyTrip search for Flight functionality
	Scenario: To verify MakeMy Trip flight search with Valid Values
	  Given Launch the borwser and enter the URL
		When i see a popup please close it
		When i Select From location as
		And i select To Location
		And i select Date
		And i click on SearchButton
		Then i validate the search result displays as per the search criteria
		And Close the browser
		
	Scenario: To verify MakeMy Trip flight search with Valid Values with harrdcoded data
	  Given Launch the borwser and enter the URL
		When i see a popup please close it
		When i Select From location as follow "BLR"
		And i select To Location as follow "PNQ"
		And i select Date as follow "29"
		And i click on SearchButton
		Then i validate the search result displays as per the search criteria
		And Close the browser
		
		Scenario Outline: To verify MakeMy Trip flight search with Valid Values with parameterized data
	  Given Launch the borwser and enter the URL
		When i see a popup please close it
		When i Select From location as follow by <from>
		And i select To Location as follow by <to>
		And i select Date as follow by <date>
		And i click on SearchButton
		Then i validate the search result displays as per the search criteria
		And Close the browser
		
		Examples: 
      | from  | to | date  |
      | MAA |     PNQ | 29 |
      | PNQ |     MAA | 28 |
      | BLR |     MAA | 27 |
		