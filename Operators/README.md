# Operators

## Is a special symbol that is applied to a set of variables.

	1. Post-unary operatos -> expression++, expression-- (First Value after the increment)
	2. pre-unary operators -> ++expression, --expression--
	3. Other unary operators : +,-,!
	4. Multiplication/Division/Modulus:*,/,%
	5. Addition/Substraction: +,-
	6. Shift oeprators : <<,>>,>>>
	7. Relational operators: <,>,<=, >=, instanceof.
	8. Equal to/ not equal to ==, !=
	9. Logical operators: &,,|
	10. Short-circuit logical operators : &&, ||
	11. TErnary operators: boolean operator ? expression1 : expression2;
	12. Assignment operator: =, +=, -=, /=, %=.
	
## Arithmetic Operators.

## Numeric Promotion Rules.

	1. If two values have different data types, Java automatycally promote to the longer data type.
	2. 
	
## Examples 

	int y = 4
	double x = 3 + 2 * --y -> 9
	
	---------------------------
	
	int x = 2 * 5 + 3 * 4 - 8; -> 14
	
	---------------------------
	
	int x = 2 * ((5 + 3) * 4 - 8 ) --> 48;
	
	System.out.print(9/3); --> 3
	System.out.print(9%3); --> 0
	
	System.out.print(11/3); --> 3
	System.out.print(11%3); --> 2
	
	System.out.print(10/3); --> 3
	System.out.print(10%3); --> 1

## ¿ Cual es el tipo de dato por x * y ?

	1. 
		int x = 1;
		long y = 33;
		R:// -> long
		
	2. 	double x = 39.21;
		float y = 2.1; 
		R:// -> No compila por que 2.1 es double deberia ser 2.1f.
		
	3. 	short x = 10;
		short y = 3;
		R// -> int, todos los tipos de datos se promueven a enteros al hacer una operacion aritmetica.
		
## ¿Cual es el tipo de datos de x * y /z ?

	short x = 14;
	float y = 13;
	double z = 30;
	R/ --> Double.
	
## ¿Cuales es valor de x?

	1. int x +=2; -> No compila por que x no estaba declarada anteriormente.
	2. double x = + 1.21;
	3. boolean x = -true; -> 
	4. int x = !5; -> no Comp
	5. boolean x = !true;