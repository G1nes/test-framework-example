# test-framework-example

In order to authorize in UI tests you should set ENV variables:
USER_EMAIL
USER_PASSWORD

In order to authorize in API tests you should set ENV variable:
TOKEN (unknown authorization method)

UI tests

Requirements for 1 and 2 tests: Should be realized in one test-class


Test 1: (Create this test without cycles in 6 steps (like for, foreach and etc))

1. Navigate to https://my.whisk-dev.com/

2. Sign in

3. Navigate to Shopping tab

4. Create Shopping list

5. Add 5 items

6. Check by Name that 5 items are added to Shopping list (check each name like a single test)

Test 2: (test would be failed because there is default shopping list)

1. 1-4 steps from 1 test

2. Delete Shopping list

3. Check that user doesn't have Shopping lists


Back-end tests:

Requirements: Create tests in one test-class and realized precondition from 1 step for all back tests

host: https://api.whisk-dev.com/

Content-type: application/json

Authorization: Bearer TFGMcztdwVSc17mtkqbXsPyBsEFNk3FqRMVZdLppFQYQ4w6FZLT6EbcKi1vNF3TZ

Test 1:

1. Create Shopping list POST: /list/v2

body:

{

"name": "string",

"primary": false

}

2. Get Shopping List by id: GET /list/v2/{id}

3. Verify that response contains necessary id

4. Verify that Shopping list is empty (content object is empty)

Test 2: (will fail because statusCode == 400 && responseMessage != "shoppingList.notFound")

1. 1 step from Test 1

2. Delete Shopping list by id DELETE: /list/v2/{id}

3. Get Shopping List by id: GET /list/v2/{id}

4. Verify that code response = 200

5. Verify that response message is 'shoppingList.notFound'

