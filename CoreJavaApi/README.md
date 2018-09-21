# Core Java Api

API -> Aplication Programming interface.

## String Class

String is basically a sequence of characters.

	String name = "Fluffy";
	String name = new String("Fluffy");
	
Both give you a reference variable of type name pointing to the String object.
Remember String class is special and doesn´t need to be instantiated with new.
	
As we can see in the Chapter 1, this is an example of a reference type(What is this.). But something is missing here.

## Concatenation.

	1.What is "1" + "2"? -> "12" Java combine the two String objects. Placing one String before the other String.
	2. The + operator can be used in two ways.
	
	Rules:
	1. If both operands are numerics, + means numeric addition.
	2. If either operand is a String, + means concatenation.
	3. The expression is evaluated left to right.
	
	4: String s = "1"; 		// s = 1;
	5: s += "2";			// s = 12;
	6: s += 3;				// s = 123;


## Inmutability.

You won’t be asked to identify whether custom classes are immutable on the exam, but it’s helpful to see an example. Consider the following code:

		class Mutable {  
			private String s;  
			public void setS(String newS){ s = newS; }  // Setter makes it mutable  
			public String getS() { return s; }
		} 
		
		final class Immutable {
			private String s = "name";  
			public String getS() { return s; } 
		}

	1. Once a String object is created, it is not allowed to change. It cannot ve made larger or smaller
	and you cannot change one of the characters inside it.
	
	2. Mutable is another work for changeable. Inmutable is the opposite- an object that cant be changed
	once it's created. On the OCA examn you need to know that String is immutable.
	
	3. Immutable only has a getter. Therés no way to change the value of $ once it's set.
	
	4. Also immutable classes in java are final, and subclasses cant add mutable behavior.
	
	String s1 = "1";
	String s2 = s1.concat("2");
	s2.concat("3");
	System.out.println(s2) --> R // -> 12
	
## String Pool.

	Since Strings are everywhere in java, They use up a lot of memory. In some produccion application, they can
	use up 25-40 percent of the memory in the entire program. Jav realizes that many strings repetat in the program and 
	solves this issue by reusing common ones.
	
	1. The string pool, also known as the intern pool, is a location in the java virtual machine (jvm)
	that collects all these strings.
	
	2. The string pool contains literal values that appear in your programs. For example "name" is a literal and
	therefore  goes into the string pool. MyObject.toString() is a string but not a literal, so it does not go into the string pool.
	
	3. String not in the string pool are garbage collected just like any other object.
	
	String name = "Fluffy";					// This use the string pool
	String name = new String("Fluffy");		// This dont use the string pool, create a new object even though it is less efficient.
	
## Important String Methods.

	It's important to remember that String is a sequence of characters and Java counts from 0 when indexed.
	
		a  n  i  m  a  l  s
		0  1  2  3  4  5  6
		
	1. length()
	
	1.1 The method lenght() returns the number of characters in the String. The method signature is as follows.
	
	
	1.2 Method Signature -> int length(). // Return int
	
		String animals = "animals";
		animals.length(); // 7
	
	Wait didn't we just tell you that Java count from 0? The difference is that zero counting happens only
	when you're using indexes or position within a list. When determining the total size or length, Java uses
	normal counting again.
	
	2. charAt()
	2.1 The method charAt() lets you query the string to find out what character is at specific index.
	
	2.2 Method Signature char charAt(int index)
	
	String animals = "animals";
	System.out.println(animals.charAt(0)); // a
	System.out.println(animals.charAt(6)); // s
	System.out.println(animals.charAt(7)); // Throw exception.
	
	3. indexOf()
	3.1 The method indexOf() looks ar the character in the string and finds the first index that matches 
	the disired value. indexOf can work with an individual character or a whole String as input. It can
	also  start from a request position.
	
	3.2 Method Signature.
		
		int indexOf(char ch);
		int indexOf(char ch, index fromIndex);
		int indexOf(String str);
		int indexOf(String str, index fromIndex);
		
	
		String animals = "animals";
		System.out.println(animals.indexOf('a'));  // 0
		System.out.println(animals.indexOf('al')); // 4	
		System.out.println(animals.indexOf('a',4));// 4
		System.out.println(animals.indexOf('al', 5));	// -1

	3.3 indexOf() return -1 when no match is found.
	
	4. substring().
	4.1 The method substring() also looks for character in a string. It return parts of the Strng.
	The first parameter is the index to start with for the returned string. There is an optional second
	parameter, which is the end index you want to stop at.
	
	4.2 Method signature.
	
		String substring(int beginIndex);
		String substring(int beginIndex, int endIndex);
		
		String animals = "animals";
		System.out.println(animals.substring(3)); // mals
		System.out.println(animals.substring(animals.indexOf('m'))); // mals
		System.out.println(animals.substring(3, 4)); // m
		System.out.println(animals.substring(3, 7)); // mals
		
	4.3 The substring method is the trickiest string method on the exam.
	
		String animals = "animals";
		System.out.println(animals.substring(3,3)); // empty
		System.out.println(animals.substring(3,2)); // throws a exception --> because the index can be backward.
		System.out.println(animals.substring(3,8)); // throws a exception --> theres no eight position.
		
		
	4.4 Let's review this one more time since substring() is so tricky. The method returns the string starting from 
	the request index. if an end index is requested, it stop right before that index. otherwise, it goes to the
	end of the string.
	
	5. toLowerCase() and toUpperCase().
	
	5.1 Method signature 
		
		String toLowerCase();
		String toUpperCase();
		
		String animals = "animals";
		System.out.println(animals.toUpperCase()); // "ANIMALS"
		System.out.println("AbCd123".toLowerCase()); // "abcd123"
		
	5.2 Also remember that string are inmutable, so the original string stays the same.
	
	6. equals() and equalsIgnoreCase().
	
	6.1 The equals() method checks whether two String objectcontain exactly the same characters in the same order.
	The equalsIgnoreCase() method checks whether two String object contain the same character with the exception
	that it will convert the characters case if needed.
	
	6.2 Method Signature.
	
		boolean equals(String str);
		boolean equalsIgnoreCase(String str);
		
		String animals = "animals";
		System.out.println("abc".equals("ABC")); // false
		System.out.println("abc".equals("abc")); // true
		System.out.println("abc".equalsIgnoreCase("ABC")); // true
		
	7. startsWith() and endsWith();
	
	7.1 look at whether the provided value matches part of the String.
	
		boolean startsWith(String prefix);
		boolean endsWith(String suffix);
		
		String animals = "animals";
		System.out.println(animals.startsWith("a")); // true
		System.out.println(animals.startsWith("A")); // false
		System.out.println(animals.endsWith("a")); // false
		System.out.println(animals.endsWith("s")); // true
		
	7.2 Check that these method are case-sensitive.
	
	8. contains()
	
	8.1 The contains method also looks for matches in the Stirng. The match can be anuwhere in the String.
	
	8.2 Method Signature.
	
		boolean contains(String str)
		
		System.out.println("abc".contains("b")); // true 
		System.out.println("abc".contains("B")); // false
		
	8.3 Again, contains method is case-sensitive.
	
	9. replace().
	
	9.1 The replace method does a simple search and replace on the string. There's a version that takes chat parameters
	as well as a version that takes charSequence parameters. 
	
	9.2 Method Signature
	
	String replace(char oldChar, char newChar)
	String replace(CharSequence oldChar, CharSequence newChar)
	
	System.out.println("abcabc".replace('a', 'A')); // AbcAbc 
	System.out.println("abcabc".replace("a", "A")); // AbcAbc

	9.3 Remember the String class is immutable.
	
	10. trim().
	
	10.1 The trim method remove whitespace from the beggini to the end of a String. In terms of the exam
	whitespaces consistes of spaces along with the \t(tab) and \n(newline);
	
	10.2 Method Signature
	
		public String trim()
	
	
		System.out.println("abc".trim());           // abc 
		System.out.println("\t   a b c\n\r".trim()); // a b c
		
## Method Chaining

	It is common to call multiple methods on the same String, as shown here
	
	String start = "AniMaL   ";
	String trimmed = start.trim();                 // "AniMaL"
	String lowercase = trimmed.toLowerCase();      // "animal" 
	String result = lowercase.replace('a', 'A');   // "Animal" 
	System.out.println(result);
	
	This is just a series of String methods. Each time one is called, the returned value is put in a new variable. 
	There are four String values along the way, and Animal is output.
	
	If you want to evade to create these four variables you cna use the method chaining.
	
	String result = "AniMaL   ".trim().toLowerCase().replace('a', 'A'); 
	System.out.println(result);
	
	5: String a = "abc"; 
	6: String b = a.toUpperCase(); 
	7: b = b.replace("B", "2").replace('C', '3'); 
	8: System.out.println("a=" + a); 
	9: System.out.println("b=" + b);



	
	
		
		