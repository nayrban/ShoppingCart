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
