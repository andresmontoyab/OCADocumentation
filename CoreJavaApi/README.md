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


## Usign String BuilderClass

A small program can create a lot of String objects very quickly. For example, how many
do you think this piece of code creates?

	10: String alpha = "";
	11: for(char current = 'a'; current <= 'z'; current++)
	12: alpha += current;
	13: System.out.println(alpha)
	
This sequence of events continues, and after 26 iterations through the loop, a total of 27
objects are instantiated, most of which are immediately eligible for garbage collection.
This is very ineffi cient. Luckily, Java has a solution. The StringBuilder class
creates a String without storing all those interim String values. Unlike the String class,
StringBuilder is not immutable.

	15: StringBuilder alpha = new StringBuilder();
	16: for(char current = 'a'; current <= 'z'; current++)
	17: alpha.append(current);
	18: System.out.println(alpha);	

## Mutability and Chaining 

We’re sure you noticed this from the previous example, but StringBuilder is not immutable.
In fact, we gave it 27 different values in the example (blank plus adding each
letter in the alphabet)

Chaining makes this even more interesting. When we chained String method calls, the
result was a new String with the answer. Chaining StringBuilder objects doesn’t work
this way. Instead, the StringBuilder changes its own state and returns a reference to itself! 

	4: StringBuilder sb = new StringBuilder("start");
	5: sb.append("+middle"); // sb = "start+middle"
	6: StringBuilder same = sb.append("+end"); // "start+middle+end"
		

	4: StringBuilder a = new StringBuilder("abc");
	5: StringBuilder b = a.append("de");
	6: b = b.append("f").append("g");
	7: System.out.println("a=" + a);
	8: System.out.println("b=" + b);	

## Creating String builder 

StringBuilder sb1 = new StringBuilder();
StringBuilder sb2 = new StringBuilder("animal");
StringBuilder sb3 = new StringBuilder(10);

## Size Vs Capacity.

The behind-the-scenes process of how objects are stored isn’t on the exam, but some
knowledge of this process may help you better understand and remember StringBuilder.
Size is the number of characters currently in the sequence, and capacity is the number
of characters the sequence can currently hold. Since a String is immutable, the size and
capacity are the same. The number of characters appearing in the String is both the size
and capacity.

For StringBuilder, Java knows the size is likely to change as the object is used. When
StringBuilder is constructed, it may start at the default capacity (which happens to be
16) or one of the programmer’s choosing. In the example, we request a capacity of 5. At
this point, the size is 0 since no characters have been added yet, but we have space for 5.

Next we add four characters. At this point, the size is 4 since four slots are taken. The
capacity is still 5. Then we add three more characters. The size is now 7 since we have
used up seven slots. Because the capacity wasn’t large enough to store seven characters,
Java automatically increased it for us.

## Important StringBuilder Methods.

charAt(), indexOf(), length(), and substring()

These four methods work exactly the same as in the String class. Be sure you can identify
the output of this example:

	StringBuilder sb = new StringBuilder("animals");
	String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));
	int len = sb.length();
	char ch = sb.charAt(6);
	System.out.println(sub + " " + len + " " + ch);

## append()

The append() method is by far the most frequently used method in StringBuilder. In fact,
it is so frequently used that we just started using it without comment. Luckily, this method
does just what it sounds like: it adds the parameter to the StringBuilder and returns a reference
to the current StringBuilder

	StringBuilder append(String str);

	StringBuilder sb = new StringBuilder().append(1).append('c');
	sb.append("-").append(true);
	System.out.println(sb); // 1c-true

## insert()	

The insert() method adds characters to the StringBuilder at the requested index and
returns a reference to the current StringBuilder

	StringBuilder insert(int offset, String str)

Pay attention to the offset in these examples. It is the index where we want to insert the
requested parameter.

	3: StringBuilder sb = new StringBuilder("animals");
	4: sb.insert(7, "-"); // sb = animals-
	5: sb.insert(0, "-"); // sb = -animals-
	6: sb.insert(4, "-"); // sb = -ani-mals


The exam creators will try to trip
you up on this. As we add and remove characters, their indexes change. When you see a
question dealing with such operations, draw what is going on so you won’t be confused.

## delete() and deleteCharAt()

The delete() method is the opposite of the insert() method. It removes characters from
the sequence and returns a reference to the current StringBuilder. The deleteCharAt()
method is convenient when you want to delete only one character

	StringBuilder delete(int start, int end)
	StringBuilder deleteCharAt(int index)

The following code shows how to use these methods:

	StringBuilder sb = new StringBuilder("abcdef");
	sb.delete(1, 3); // sb = adef
	sb.deleteCharAt(5); // throws an exception

First, we delete the characters starting with index 1 and ending right before index 3. This
gives us adef. Next, we ask Java to delete the character at position 5. However, the remaining
value is only four characters long, so it throws a StringIndexOutOfBoundsException. 

## reverse()

After all that, it’s time for a nice, easy method. The reverse() method does just what it
sounds like: it reverses the characters in the sequences and returns a reference to the current
StringBuilder

	StringBuilder reverse()

The following code shows how to use this method:

	StringBuilder sb = new StringBuilder("ABC");
	sb.reverse();


## toString()

The last method converts a StringBuilder into a String. The method signature is as
follows:

	String toString()

The following code shows how to use this method:

	String s = sb.toString();

Often StringBuilder is used internally for performance purposes but the end result
needs to be a String. For example, maybe it needs to be passed to another method that is
expecting a String

## StringBuilder vs StringBuffer.

When writing new code that concatenates a lot of String objects together, you should
use StringBuilder. StringBuilder was added to Java in Java 5. If you come across older
code, you will see StringBuffer used for this purpose. StringBuffer does the same thing
but more slowly because it is thread safe.

## Understandig Equality.

In Chapter 2, you learned how to use == to compare numbers and that object references
refer to the same object.

Some examples of ==

	StringBuilder one = new StringBuilder();
	StringBuilder two = new StringBuilder();
	StringBuilder three = one.append("a");
	System.out.println(one == two); // false
	System.out.println(one == three); // true


	String x = "Hello World";
	String y = "Hello World";
	System.out.println(x == y); // true


	String x = "Hello World";
	String z = " Hello World".trim();
	System.out.println(x == z); // false

	String x = new String("Hello World");
	String y = "Hello World";
	System.out.println(x == y); // false

The equal() application

	String x = "Hello World";
	String z = " Hello World".trim();
	System.out.println(x.equals(z)); // true

This works because the authors of the String class implemented a standard method
called equals to check the values inside the String rather than the String itself

If a class doesn’t have an equals method, Java determines whether the references point to the
same object—which is exactly what == does.

In case you are wondering, the authors of StringBuilder did not implement equals().

	 public class Tiger {
	2: String name;
	3: public static void main(String[] args) {
	4: Tiger t1 = new Tiger();
	5: Tiger t2 = new Tiger();
	6: Tiger t3 = t1;
	7: System.out.println(t1 == t1); // true
	8: System.out.println(t1 == t2); // false
	9: System.out.println(t1.equals(t2)); // false
	10: } }

## Understanding Java Arrays.

An array is an area of memory on the heap with space for a designated number of elements. A String is
implemented as an array with some methods that you might want to use when dealing with
characters specifi cally. A StringBuilder is implemented as an array where the array object is
replaced with a new bigger array object when it runs out of space to store all the characters. A
big difference is that an array can be of any other Java type.

In other words, an array is an ordered list. It can contain duplicates. You will learn
about data structures that cannot contain duplicates for the OCP exam.

## Creating an Array of primitives.

Creaing a empty array with three position.

	int[] numbers1 = new int[3];

When using this form to instantiate an array, set all the elements to the default value for
that type.

Creating an array with values.

	int[] numbers2 = new int[] {42, 55, 99};

Java recognizes that this expression is redundant. Since you are specifying the type of
the array on the left side of the equal sign, Java already knows the type. And since you
are specifying the initial values, it already knows the size. As a shortcut, Java lets you
write this:

	int[] numbers2 = {42, 55, 99};

int[] numAnimals;
int [] numAnimals2;
int numAnimals3[];
int numAnimals4 [];

Most people use the fi rst one. You could see any of these on the exam, though, so get
used to seeing the brackets in odd places.	

## Creating an Array with Reference Variables

You can choose any Java type to be the type of the array. This includes classes you create
yourself. Let’s take a look at a built-in type with String:

	public class ArrayType {
	 public static void main(String args[]) {
	 String [] bugs = { "cricket", "beetle", "ladybug" };
	 String [] alias = bugs;
	 System.out.println(bugs.equals(alias)); // true
	 System.out.println(bugs.toString()); // [Ljava.lang.String;@160bc7c0
	} }

The array does not allocate space for the String
objects. Instead, it allocates space for a reference to where the objects are really stored.

what do you think this array points to??

	class Names {
	 String names[];
	}


	class Names {
 		String names[] = new String[2];
		}


	3: String[] strings = { "stringValue" };
	4: Object[] objects = strings;
	5: String[] againStrings = (String[]) objects;
	6: againStrings[0] = new StringBuilder(); // DOES NOT COMPILE
	7: objects[0] = new StringBuilder(); // careful!		

Line 7 is where this gets interesting. From the point of view of the compiler, this is just
fi ne. A StringBuilder object can clearly go in an Object[]. The problem is that we don’t
actually have an Object[]. We have a String[] referred to from an Object[] variable. At
runtime, the code throws an ArrayStoreException

## Using Array

Now that we know how to create an array, let’s try accessing one:

	4: String[] mammals = {"monkey", "chimp", "donkey"};
	5: System.out.println(mammals.length); // 3
	6: System.out.println(mammals[0]); // monkey
	7: System.out.println(mammals[1]); // chimp
	8: System.out.println(mammals[2]); // donkey


what do you think this prints?
	
	String[] birds = new String[6];
	System.out.println(birds.length);

The answer is 6. Even though all 6 elements of the array are null, there are still 6 of
them. length does not consider what is in the array; it only considers how many slots have
been allocated.

## Sorting.

Arrays is the fi rst class provided by Java we have used that requires an import. To use it,
you must have either of the following two statements in your class:

	import java.util.* // import whole package including Arrays
	import java.util.Arrays; // import just Arrays


	int[] numbers = { 6, 9, 1 };
	Arrays.sort(numbers);
	for (int i = 0; i < numbers.length; i++)
	L System.out.print (numbers[i] + " "); // 1 6 9


	String[] strings = { "10", "9", "100" };
	Arrays.sort(strings);
	for (String string : strings);
	System.out.print(string + " ");

This time the result might not be what you expect. This code outputs 10 100 9. The
problem is that String sorts in alphabetic order, and 1 sorts before 9.

## Searching.

Java also provides a convenient way to search—but only if the array is already sorted. 	

	3: int[] numbers = {2,4,6,8};
	4: System.out.println(Arrays.binarySearch(numbers, 2)); // 0
	5: System.out.println(Arrays.binarySearch(numbers, 4)); // 1
	6: System.out.println(Arrays.binarySearch(numbers, 1)); // -1
	7: System.out.println(Arrays.binarySearch(numbers, 3)); // -2
	8: System.out.println(Arrays.binarySearch(numbers, 9)); // -5

What do you think happens in this example?

	5: int numbers = new int[] {3,2,1};
	6: System.out.println(Arrays.binarySearch(numbers, 2));
	7: System.out.println(Arrays.binarySearch(numbers, 3));

The exam creators will not expect you to know what incorrect values come
out. As soon as you see the array isn’t sorted, look for an answer choice about unpredictable
output.

## Varargs

When creating an array yourself, it looks like what we’ve seen thus far. When one is passed
to your method, there is another way it can look. Here are three examples with a main()
method:

	public static void main(String[] args)
	public static void main(String args[])
	public static void main(String... args) // varargs

The third example uses a syntax called varargs (variable arguments), which you saw in
Chapter 1. 

All you need to know is that you can use a variable defi ned using varargs as if it were a normal array.
 For example args.length and args[0] are legal.

## Multidimensional Arrays

Arrays are objects, and of course array components can be objects. It doesn’t take much
time, rubbing those two facts together, to wonder if arrays can hold other arrays, and of
course they can

## Creating a multiDimensional Array

	int[][] vars1; // 2D array
	int vars2 [][]; // 2D array
	int[] vars3[]; // 2D array
	int[] vars4 [], space [][]; // a 2D AND a 3D array

You can specify the size of your multidimensional array in the declaration if you like:

	String [][] rectangle = new String[3][2];

	rectangle[0][1] = "set";  // Put the image.

While that array happens to be rectangular in shape, an array doesn’t need to be.
Consider this one:

	int[][] differentSize = {{1, 4}, {3}, {9,8,7}};	

## Using a Multidimensional Array.

The most common operation on a multidimensional array is to loop through it. This example
prints out a 2D array:

	int[][] twoD = new int[3][2];
	for (int i = 0; i < twoD.length; i++) {
		for (int j = 0; j < twoD[i].length; j++)
	 		System.out.print(twoD[i][j] + " "); // print element
	 		System.out.println(); // time for a new row
	}	

This entire exercise would be easier to read with the enhanced for loop.

	for (int[] inner : twoD) {
		for (int num : inner)
			System.out.print(num + " ");
			System.out.println();
		}

## Understanding ArrayList.

An array has one glaring shortcoming: you have to know how many elements will be in the
array when you create it and then you are stuck with that choice. Just like a StringBuilder,
ArrayList can change size at runtime as needed. Like an array, an ArrayList is an ordered
sequence that allows duplicates.

## Creating ArrayList

As with StringBuilder, there are three ways to create an ArrayList:

	ArrayList list1 = new ArrayList();
	ArrayList list2 = new ArrayList(10);
	ArrayList list3 = new ArrayList(list2);		

The new and improved way. Java 5 introduced generics, which allow you to specify the type
of class that the ArrayList will contain.

	ArrayList<String> list4 = new ArrayList<String>();
	ArrayList<String> list5 = new ArrayList<>();	

ArrayList implements an interface called List. In other
words, an ArrayList is a List.

	List<String> list6 = new ArrayList<>();
	ArrayList<String> list7 = new List<>(); // DOES NOT COMPILE

## Using ArrayList().

ArrayList has many methods, but you only need to know a handful of them—even fewer
than you did for String and StringBuilder

## add()

The add() methods insert a new value in the ArrayList. The method signatures are as follows:

	boolean add(E element) 
	void add(int index, E element)

	ArrayList list = new ArrayList(); 
	list.add("hawk");          // [hawk]
	list.add(Boolean.TRUE);    // [hawk, true] 
	System.out.println(list);  // [hawk, true]

add() does exactly what we expect: it stores the String in the no longer empty ArrayList. It then does the same thing for the boolean. This is okay because we didn’t specify a type for ArrayList; therefore, the type is Object, which includes everything except primitives.

	ArrayList<String> safer = new ArrayList<>(); 
	safer.add("sparrow"); 
	safer.add(Boolean.TRUE);    // DOES NOT COMPILE

This time the compiler knows that only String objects are allowed in and prevents the attempt to add a boolean. Now let’s try adding multiple values to different positions.

	4: List<String> birds = new ArrayList<>();
	5: birds.add("hawk");            // [hawk] 
	6: birds.add(1, "robin");        // [hawk, robin] 
	7: birds.add(0, "blue jay");     // [blue jay, hawk, robin] 
	8: birds.add(1, "cardinal");     // [blue jay, cardinal, hawk, robin] 
	9: System.out.println(birds);    // [blue jay, cardinal, hawk, robin]

## remove()

remove() The remove() methods remove the fi rst matching value in the ArrayList or remove the element at a specifi ed index. The method signatures are as follows:

	boolean remove(Object object) 
	E remove(int index)

This time the boolean return value tells us whether a match was removed. The E return type is the element that actually got removed. The following shows how to use these methods:

	3: List<String> birds = new ArrayList<>(); 
	4: birds.add("hawk");     // [hawk] 
	5: birds.add("hawk");     // [hawk, hawk] 
	6: System.out.println(birds.remove("cardinal")); // prints false 
	7: System.out.println(birds.remove("hawk")); // prints true
	8: System.out.println(birds.remove(0)); // prints hawk 
	9: System.out.println(birds);     // []

## set()

The set() method changes one of the elements of the ArrayList without changing the size. The method signature is as follows:

	E set(int index, E newElement)

The E return type is the element that got replaced. The following shows how to use this method:

	15: List<String> birds = new ArrayList<>(); 
	16: birds.add("hawk");                    // [hawk] 
	17: System.out.println(birds.size());     // 1 
	18: birds.set(0, "robin");               // [robin] 
	19: System.out.println(birds.size());     // 1 
	20: birds.set(1, "robin");               // IndexOutOfBoundsException

## isEmpty() and size().

The isEmpty() and size() methods look at how many of the slots are in use. The method signatures are as follows:

	boolean isEmpty() int size()

The following shows how to use these methods:

	System.out.println(birds.isEmpty());     // true 
	System.out.println(birds.size());     // 0 
	birds.add("hawk");                    // [hawk] 
	birds.add("hawk");                    // [hawk, hawk]
	System.out.println(birds.isEmpty());     // false 
	System.out.println(birds.size());     // 2

## clear()

The clear() method provides an easy way to discard all elements of the ArrayList. The method signature is as follows:
void clear()

The following shows how to use this method:

	List<String> birds = new ArrayList<>(); 
	birds.add("hawk");                    // [hawk] 
	birds.add("hawk");                    // [hawk, hawk] 
	System. out .println(birds.isEmpty());     // false 
	System. out .println(birds.size());     // 2 
	birds.clear();                         // [] 
	System. out .println(birds.isEmpty());     // true 
	System.out.println(birds.size());     // 0

After we call clear(), birds is back to being an empty ArrayList of size 0.

## contains()

The contains() method checks whether a certain value is in the ArrayList. The method signature is as follows:

	boolean contains(Object object)

The following shows how to use this method:

	List<String> birds = new ArrayList<>(); 
	birds.add("hawk");                         // [hawk] 
	System.out.println(birds.contains("hawk")); // true 
	.out.println(birds.contains("robin")); // false


##equals()

Finally, ArrayList has a custom implementation of equals() so you can compare two lists to see if they contain the same elements in the same order.

	boolean equals(Object object)

The following shows an example:

	31: List<String> one = new ArrayList<>(); 
	32: List<String> two = new ArrayList<>(); 
	33: System.out.println(one.equals(two));      // true 
	34: one.add("a");                         // [a] 
	35: System.out.println(one.equals(two));     // false 
	36: two.add("a");                         // [a] 
	37: System.out.println(one.equals(two));     // true 
	38: one.add("b");                         // [a,b] 
	39: two.add(0, "b");                    // [b,a] 
	40: System.out.println(one.equals(two));     // false

## Wrapper Classes.

What happens if we want to put primitives in? Each primitive type has a wrapper class, which is an object type that corresponds to the primitive.

	Primitive Type      ||          Wrapper Class                || Example of constructing.
	boolean             || 			Boolean 					 || new Boolean(true)
	byte             	|| 			Byte 						 || new Byte((byte) 1))
	short             	|| 			Short 						 || new Short(short) 1)
	long             	|| 			Integer 					 || new Integer(1)
	float             	|| 			Float 						 || new Float(1.0)
	double             	|| 			Long 						 || new Long(1)
	int             	|| 			Double 	 					 || new Double(1.0)
	char             	|| 			Character  					 || new Character('c')	 

 The wrapper classes also have a method that converts back to a primitive.

 There are also methods for converting a String to a primitive or wrapper class. You do need to know these methods. The parse methods, such as parseInt(), return a primitive, and the valueOf() method returns a wrapper class.

	int primitive = Integer.parseInt("123"); 
	Integer wrapper = Integer.valueOf("123");

If the String passed in is not valid for the given type, Java throws an exception

	int bad1 = Integer.parseInt("a");               // throws NumberFormatException 
	Integer bad2 = Integer.valueOf("123.45");       // throws NumberFormatException

	Wrapper class 			|| Converting String to primitive 		|| Converting String to wrapper class
	Boolean 				|| Boolean.parseBoolean("true"); 		|| Boolean.valueOf("TRUE");
	Byte 					|| Byte.parseByte("1"); 				|| Byte.valueOf("2");
	Short 					|| Short.parseShort("1"); 				|| Short.valueOf("2");
	Integer 				|| Integer.parseInt("1"); 				|| Integer.valueOf("2");
	Long 					|| Long.parseLong("1"); 				|| Long.valueOf("2");
	Float 					|| Float.parseFloat("1"); 				|| Float.valueOf("2.2");
	Double 					|| Double.parseDouble("1");				|| Double.valueOf("2.2");
	Character 				|| None 								|| None

Also, the Character class doesn’t participate in the parse/ valueOf methods. Since a String is made up of characters, you can just call charAt() normally. 

## Autoboxing.

Why won’t you need to be concerned with whether a primitive or wrapper class is returned, you ask? Since Java 5, you can just type the primitive value and Java will convert it to the relevant wrapper class for you. 

	4: List<Double> weights = new ArrayList<>(); 
	5: weights.add(50.5);               // [50.5] 
	6: weights.add(new Double(60));     // [50.5, 60.0] 
	7: weights.remove(50.5);               // [60.0] 
	8: double first = weights.get(0);     // 60.0

Be careful when autoboxing into Integer. What do you think this code outputs?

	List<Integer> numbers = new ArrayList<>(); 
	numbers.add(1); 
	numbers.add(2); 
	numbers.remove(1); 
	System.out.println(numbers);

 If you want to remove the 2, you can write numbers.remove(new Integer(2)) to force wrapper class use. 

## Converting Between array and List.

You should know how to convert between an array and an ArrayList. Let’s start with turning an ArrayList into an array:

	3: List<String> list = new ArrayList<>(); 
	4: list.add("hawk");
	5: list.add("robin"); 
	6: Object[] objectArray = list.toArray(); 
	7: System.out.println(objectArray.length);     // 2 
	8: String[] stringArray = list.toArray(new String[0]); 
	9: System.out.println(stringArray.length);     // 2

Converting from an array to a List is more interesting. The original array and created array backed List are linked. When a change is made to one, it is available in the other.

	20: String[] array = { "hawk", "robin" };     // [hawk, robin] 
	21: List<String> list = Arrays.asList(array); // returns fixed size list
	22: System.out.println(list.size());     // 2 
	23: list.set(1, "test");          // [hawk, test] 
	24: array[0] = "new";               // [new, test] 
	25: for (String b : array) System.out.print(b + " "); // new test 
	26: list.remove(1);     // throws UnsupportedOperation Exception

## Sorting.

Sorting an ArrayList is very similar to sorting an array. You just use a different helper class:

	List<Integer> numbers = new ArrayList<>(); 
	numbers.add(99); 
	numbers.add(5); 
	numbers.add(81); 
	Collections.sort(numbers); 
	System.out.println(numbers); [5, 81, 99]

As you can see, the numbers got sorted, just like you’d expect. Isn’t it nice to have something that works just like you think it will

## Working with Data and Times.

As with an ArrayList, you need an import statement to work with the date and time classes. Most of them are in the java.time package. To use it, add this import to your program

	import java.time.*;	import time classes.

## Creating Date and Times.

When working with dates and times, the first thing to do is decide how much information you need. The exam gives you three choices

## LocalDate 

Contains just a date - no time and no time zone.  A good example of LocalDate is your birthday this year.

## LocalTime 

Contains just a time—no date and no time zone. A good example of LocalTime is midnight. It is midnight at the same time every day

## LocalDateTime

Contains both a date and time but no time zone. A good example of LocalDateTime is “the stroke of midnight on New Year’s.” 

	System.out.println(LocalDate.now());   // Date
	System.out.println(LocalTime.now()); 	// Time
	System.out.println(LocalDateTime.now()); // Both


	2018-09-24
	17:50:52.037
	2018-09-24T17:50:52.037

## Creating Dates.

Method Signature 

	public static LocalDate of(int year, int month, int dayOfMonth) 
	public static LocalDate of(int year, Month month, int dayOfMonth)

Examples 

	LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20); 
	LocalDate date2 = LocalDate.of(2015, 1, 20);

Both pass in the year, month, and date. Although it is good to use the Month constants (to make the code easier to read), you can pass the int number of the month directly.

## Creating a Time

When creating a time, you can choose how detailed you want to be. You can specify just the hour and minute, or you can add the number of seconds. You can even add nanoseconds if you want to be very precise.

Method Signature.

	public static LocalTime of(int hour, int minute)
	public static LocalTime of(int hour, int minute, int second) 
	public static LocalTime of(int hour, int minute, int second, int nanos)


## Creating DateTime

	LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30); 
	LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);

Method Signature.

	public static LocalDateTime of(int year, int month,   int dayOfMonth, int hour, int minute) 
	public static LocalDateTime of(int year, int month,   int dayOfMonth, int hour, int minute, int second) 
	public static LocalDateTime of(int year, int month,   int dayOfMonth, int hour, int minute, int second, int nanos) 
	public static LocalDateTime of(int year, Month month,   int dayOfMonth, int hour, int minute) 
	public static LocalDateTime of(int year, Month month,   int dayOfMonth, int hour, int minute, int second) 
	public static LocalDateTime of(int year, Month month,   int dayOfMonth, int hour, int minute, int second, int nanos) 
	public static LocalDateTime of(LocalDate date, LocalTime)

Did you notice that we did not use a constructor in any of the examples? The date and time classes have private constructors to force you to use the static methods. The exam creators may try to throw something like this at you:

	LocalDate d = new LocalDate(); // DOES NOT COMPILE

Don’t fall for this. You are not allowed to construct a date or time object directly. Another trick is to see what happens when you pass invalid numbers to of(). For example:

	LocalDate.of(2015, Month.JANUARY, 32)     // throws DateTimeException

## Old way Vs New Way

// Put Image.

You can see some of the problems with the “old way” in the following table. There wasn’t a way to specify just a date without the time. The Date class represented both the date and time whether you wanted it to or not. Trying to create a speciﬁ c date required more code than it should have. Month indexes were 0 based instead of 1 based, which was confusing. 

## Manipuling Dates and Times.

Adding to a date is easy. The date and time classes are immutable, just like String was. This means that we need to remember to assign the results of these methods to a reference variable so they are not lost.

	12: LocalDate date = LocalDate.of(2014, Month.JANUARY, 20); 
	13: System.out.println(date);          // 2014-01-20 
	14: date = date.plusDays(2); 
	15: System.out.println(date);          // 2014-01-22 
	16: date = date.plusWeeks(1);
	17: System.out.println(date);          // 2014-01-29 
	18: date = date.plusMonths(1); 
	19: System.out.println(date);          // 2014-02-28 
	20: date = date.plusYears(5); 
	21: System.out.println(date);          // 2019-02-28

There are also nice easy methods to go backward in time. This time, let’s work with LocalDateTime.

	22: LocalDate date = LocalDate.of(2020, Month.JANUARY, 20); 
	23: LocalTime time = LocalTime.of(5, 15); 
	24: LocalDateTime dateTime = LocalDateTime.of(date, time); 
	25: System.out.println(dateTime);          // 2020-01-20T05:15 
	26: dateTime = dateTime.minusDays(1); 
	27: System.out.println(dateTime);          // 2020-01-19T05:15 
	28: dateTime = dateTime.minusHours(10); 
	29: System.out.println(dateTime);          // 2020-01-18T19:15 
	30: dateTime = dateTime.minusSeconds(30); 
	31: System.out.println(dateTime);          // 2020-01-18T19:14:30

It is common for date and time methods to be chained. For example, without the print statements, the previous example could be rewritten as follows:

	LocalDate date = LocalDate.of(2020, Month.JANUARY, 20); 
	LocalTime time = LocalTime.of(5, 15); 
	LocalDateTime dateTime = LocalDateTime.of(date2, time).minusDays(1).minusHours(10).minusSeconds(30);


	LocalDate date = LocalDate.of(2020, Month.JANUARY, 20); 
	date.plusDays(10); 
	System.out.println(date);

It prints January 20, 2020. Adding 10 days was useless because we ignored the result. Whenever you see immutable types, pay attention to make sure the return value of a method call isn’t ignored. 

The exam also may test to see if you remember what each of the date and time objects includes. Do you see what is wrong here?

	LocalDate date = LocalDate.of(2020, Month.JANUARY, 20); 
	date = date.plusMinutes(1);     // DOES NOT COMPILE

LocalDate does not contain time. This means you cannot add minutes to it..

## Converting to Long

LocalDate and LocalDateTime have a method to convert them into long equivalents in relation to 1970. What’s special about 1970? That’s what UNIX started using for date standards, so Java reused it. And don’t worry—you don’t have to memorize the names for the exam.

	1.LocalDate has toEpochDay(), which is the number of days since January 1, 1970.
	2. LocalDateTime has toEpochTime(), which is the number of seconds since January 1, 1970.


## Working with periods.

Luckily, Java has a Period class that we can pass in. This code does the same thing as the previous example:

	public static void main(String[] args) {  
		LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);  
		LocalDate end = LocalDate.of(2015, Month.MARCH, 30);  
		Period period = Period.ofMonths(1);               // create a period  
		performAnimalEnrichment(start, end, period); 
	} 

	private static void performAnimalEnrichment(LocalDate start, LocalDate end,   Period period) {               // uses the generic period
		LocalDate upTo = start; 
		while (upTo.isBefore(end)) {    
			System.out.println("give new toy: " + upTo);    
			upTo = upTo.plus(period);     // adds the period  
		}
	}

There are fi ve ways to create a Period class:

	Period annually = Period.ofYears(1);               // every 1 year Period quarterly = Period.ofMonths(3);               // every 3 months
	Period everyThreeWeeks = Period.ofWeeks(3);          // every 3 weeks Period everyOtherDay = Period.ofDays(2);          // every 2 days Period everyYearAndAWeek = Period.of(1, 0, 7);          // every year and 7 days

The last thing to know about Period is what objects it can be used with. Let’s look at some code:

	3: LocalDate date = LocalDate.of(2015, 1, 20); 
	4: LocalTime time = LocalTime.of(6, 15); 
	5: LocalDateTime dateTime = LocalDateTime.of(date, time); 
	6: Period period = Period.ofMonths(1); 
	7: System.out.println(date.plus(period));          // 2015-02-20 
	8: System.out.println(dateTime.plus(period));          // 2015-02-20T06:15 
	9: System.out.println(time.plus(period));   // UnsupportedTemporalTypeException

As you can see, you’ll have to pay attention to the type of date and time objects every place you see them.

## Formating Dates and Time.

The date and time classes support many methods to get data out of them:

	LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
	System.out.println(date.getDayOfWeek());     // MONDAY 
	System.out.println(date.getMonth());          // JANUARY 
	System.out.println(date.getYear());          // 2020 
	System.out.println(date.getDayOfYear());     // 20

DateTimeFormatter can be used to format any type of date and/or time object. What changes is the format. DateTimeFormatter is in the package java.time.format.

	LocalDate date = LocalDate.of(2020, Month.JANUARY, 20); 
	LocalTime time = LocalTime.of(11, 12, 34); 
	LocalDateTime dateTime = LocalDateTime.of(date, time);
	System.out.println(date .format(DateTimeFormatter.ISO_LOCAL_DATE)); 
	System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME)); 
	System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

ISO is a standard for dates. The output of the previous code looks like this:

	2020-01-20 
	11:12:34 
	2020-01-20T11:12:34

## Predefing Formats

There are two predefi ned formats that can show up on the exam: SHORT and MEDIUM. The other predefi ned formats involve time zones, which are not on the exam.

	LocalDate date = LocalDate.of(2020, Month.JANUARY, 20); 
	LocalTime time = LocalTime.of(11, 12, 34); 
	LocalDateTime dateTime = LocalDateTime.of(date, time);
	DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT); 
	DateTimeFormatter mediumF = DateTimeFormatte.ofLocalizedDateTime(FormatStyle.MEDIUM); 
	System.out.println(shortF.format(dateTime));  // 1/20/20 11:12 AM 
	System.out.println(mediumF.format(dateTime));   // Jan 20, 2020 11:12:34 AM

## Custom Formats.

If you don’t want to use one of the predefi ned formats, you can create your own. For example, this code spells out the month:

	DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm"); 
	System.out.println(dateTime.format(f));     // January 20, 2020, 11:12

## Parsing Dates and Times

Now that you know how to convert a date or time to a formatted String, you’ll fi nd it easy to convert a String to a date or time. Just like the format() method, the parse() method takes a formatter as well. If you don’t specify one, it uses the default for that type.

	DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy"); 
	LocalDate date = LocalDate.parse("01 02 2015", f); 
	LocalTime time = LocalTime.parse("11:22"); 
	System.out.println(date);          // 2015-01-02 
	System.out.println(time);          // 11:22










