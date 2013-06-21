Feature: Hello World uses Friendly Greeting
  As a user
  I want to be greeted in a friendly fashion
  So that I feel comfortable interacting with the application

  Scenario: Application says hello
	Given I have a HelloWorld instance without arguments
	 When I ask it to say hi
	 Then it should say "Hello World!"
	 
  Scenario: Application says personalized hello
	Given I have a HelloWorld instance with "Jason"
	 When I ask it to say hi
	 Then it should say "Hello Jason!"
	 
  Scenario Outline: Application says personalized <greeting> for <name>
  	Given I have a HelloWorld instance with a greeting of "<greeting>" and name of "<name>"
  	 When I ask it to say hi
  	 Then it should say "<greeting> <name>!"
  	Examples:
  		| greeting | name   |
  		| Hello    | Jason  |
  		| Yo       | Jessi  |
  		| Hola     | Shelia |
  		