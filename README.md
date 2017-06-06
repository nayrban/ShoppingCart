I am using eclipse and to setup use this guide

https://examples.javacodegeeks.com/enterprise-java/jboss-drools-tutorial-beginners/

I need to refactor some code in the DTO project

This projects runs on <strong>localhost:8080/</strong>

Have one method here vi/customer/discount is a <strong>POST</strong> method

Can use this json to test in tools like postman <br>
<code>
{"cart":
	{"cartItems": 
		[ 
			{"qty":1, "product":{"price":15000, "desc":"Laptop"}},
			{"qty":2, "product":{"price":5000, "desc":"Mobile"}},
			{"qty":5, "product":{"price":2000, "desc":"Books"}}
		],
		"discount":0
	}, 
"coupon":"DISC01",
"isNew":true }</code>
<hr>
<h2>Description</h2>
<p>This project emulate a Shopping Cart applying some rules to generate discounts over the cart items.
You can edit the rule using different amounts or adding more rules.

In those two basic rules we have two scenarios,
First if  the user have a discount coupon we apply a % and the other one is if the user are new. A user can get both rules at same time.

Feel  free and change any code and create a new pull request.

This project is a mix that include the first link, and those others.
<br>
https://github.com/gratiartis/buspass-ws
<br>
https://examples.javacodegeeks.com/enterprise-java/jboss-drools/drools-decision-table-example/
</p>
