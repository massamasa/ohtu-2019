Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new user is selected
        When  a valid username "liisa" and password "salainen1" and matching password confirmation are given
        Then  a new user is created

    Scenario: creation fails with too short username and valid password
        Given command new user is selected
        When  a too short username "aa" and valid password "salainen1" are given
        Then  user is not created and error "username should have at least 3 characters" is reported   

        
    Scenario: creation fails with correct username and too short password
        Given command new user is selected
        When  a correct username "username" and too short password "passw0r" and matching password confirmation are given
        Then  user is not created and error "password should have at least 8 characters" is reported


    Scenario: creation fails when password and password confirmation do not match
        Given command new user is selected
        When  a correct username "matti" and valid password "passw0rd" and non-matching password confirmation "passwr0d" are given
        Then user is not created and error "password and password confirmation do not match" is reported   