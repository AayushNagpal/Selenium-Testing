
	Feature: Test facebook smoke scenario

	Scenario: Test login with valid credentials
				Given Open firefox and start application
				When I enter valid "sample@gmail.com" and valid "forinfo@123"
				Then user should be able to login successfully
				Then application should be closed