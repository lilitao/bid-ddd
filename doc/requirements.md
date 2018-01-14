### Story1. Register Seller

As a seller
I want to register
So that I can sell my things through the bid site.

AC1:
Given I provide my user name and password
When I register
Then I can register successfully.

AC2:
Given I provide my user name and password, which is less than 6 characters
When I register
Then I can NOT registered as a seller.

AC3:
Given I register as a seller
When I registered successfully
Then I will received a email

### Story2. Add performance log

As a operation dev
I want to know how long a method running
So that I can tuning the performance