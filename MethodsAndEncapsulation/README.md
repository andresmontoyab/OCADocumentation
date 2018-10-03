# Methods and Encapsulation 

## Designing Methods

	Access modifier | Optional Specifier | Return Type | method name | parentheses | exception
		public final void nap(int minuts) throws Exception. 
		
## Access Modifiers

public, private, protected and default(Package private)

## Optional Specifiers.

static, abstract, final, synchronized, native, strictfp.

## Return Type 

The return type might be an actual Java type such as String or int. 
If there is no return type, the void keyword is used
 
Remember that a method must have a return type. 
If no value is returned, the return type is void. You cannot omit the return type
 
Methods with a return type other than void are required to have a return statement
inside the method body

## Method Name.

the fi rst character is not allowed to be a number, and reserved words are not allowed. By convention, 
methods begin with a lowercase letter but are not required to.

## Parameter List.

Although the parameter list is required, it doesn’t have to contain any parameters. 
This means you can just have an empty pair of parentheses after the method name, such as void nap(){}.
If you do have multiple parameters, you separate them with a comma.

## Exception List.

Code can indicate that something went wrong by throwing an exception.

	public void twoExceptions() throws   IllegalArgumentException, InterruptedException { }
	
## Method Body 

The fi nal part of a method declaration is the method body (except for abstract methods and interfaces,
but you don’t need to know about either of those until next chapter). A method body is simply a
code block. It has braces that contain zero or more Java statements.

## Working with Varargs.

. A vararg parameter must be the last element in a method’s parameter list. This implies you are only allowed to have one vararg
parameter per method.

	public void walk1(int... nums) { } 
	public void walk2(int start, int... nums) { }
	public void walk3(int... nums, int start) { } // DOES NOT COMPILE 
	
Or

	public static void walk(int start, int... nums) 
	{ 
		System. out .println(nums.length);
	} 

	walk(1);                    // 0 
	walk(1, 2);                 // 1
	walk(1, 2, 3);              // 2
	walk(1, new int[] {4, 5});  // 2 

# Access Modifiers.

## Private.

Private access is easy. Only code in the same class can call private methods or access private fields.

	package pond.duck;
	public class FatherDuck { 
		private String noise = "quack"; 
		private void quack() { 
			System.out.println(noise);     // private access is ok 
		}
		private void makeNoise() { 
			quack();                    // private access is ok 
		}
	}
	
	
	package pond.duck; 
		public class BadDuckling { 
		public void makeNoise() { 
			FatherDuck duck = new FatherDuck(); 
			duck.quack();                       // DOES NOT COMPILE 
			System.out.println(duck.noise);     // DOES NOT COMPILE 
		}
	}
	
## Default(Package Private)

Allows classes in the same package to access her members. When there is no access modifier, Java uses
the default, which is package private access.


	package pond.duck;
		public class MotherDuck {  
		String noise = "quack";  
		void quack() {    
			System.out.println(noise);     // default access is ok  
		}  
		private void makeNoise() 
		{    
			quack();                    // default access is ok  
		} 
	}


	package pond.duck;
	public class GoodDuckling {
		public void makeNoise() {
			MotherDuck duck = new MotherDuck(); 
			duck.quack();                         // default access
			System.out.println(duck.noise);          // default access  
		}
	}
	
## Protected Access.

Protected access allows everything that default (package private) access allows and more. 
The protected access modifi er adds the ability to access members of a parent class.

package pond.shore; 
	public class Bird 
	{  
	protected String text = "floating";          // protected access  
	protected void floatInWater() {               // protected access    
		System.out.println(text);  
	} 
}

package pond.goose;
import pond.shore.Bird;               // in a different package 
	public class Gosling extends Bird {     // extends means create subclass  
	public void swim() 
	{    
		floatInWater();               // calling protected member    
		System.out.println(text);     // calling protected member  
	}
}

	package pond.shore;                    // same package as Bird 
	public class BirdWatcher {  
		public void watchBird() 
		{    
			Bird bird = new Bird();    
			bird.floatInWater();               // calling protected member    
			System.out.println(bird.text);     // calling protected member  
		}
	}

	package pond.inland;
	import pond.shore.Bird;               // different package than Bird 
		public class BirdWatcherFromAfar {  
		public void watchBird() 
		{    
			Bird bird = new Bird();    
			bird.floatInWater();               // DOES NOT COMPILE
			System.out.println(bird.text);     // DOES NOT COMPILE  
		} 
	}

  
	package pond.swan;
	import pond.shore.Bird;     // in different package than Bird
	public class Swan extends Bird {     // but subclass of bird
		public void swim() {
			floatInWater();               // package access to superclass
			System.out.println(text);     // package access to superclass
		}
		public void helpOtherSwanSwim() {
		Swan other = new Swan();
			other.floatInWater();          // package access to superclass
			System.out.println(other.text);// package access to superclass
		}
		public void helpOtherBirdSwim() {
		Bird other = new Bird();
			other.floatInWater();               // DOES NOT COMPILE
			System.out.println(other.text);      // DOES NOT COMPILE
		}
	}
	
## Public Access

Protected access was a tough concept. Luckily, the last type of access modifier is easy: 
public means anyone can access the member from anywhere.

## Design Static Methods and Fields.

Static methods don’t require an instance of the class. They are shared among all users of the class. 
You can think of statics as being a member of the single class object that exist independently of 
any instances of that class.

Static methods have two main purposes:

	1. For utility or helper methods that don’t require any object state. Since there is no need to 
	access instance variables, having static methods eliminates the need for the caller to instantiate
	the object just to call the method.
	
	2.  For state that is shared by all instances of a class, like a counter. All instances must 
	share the same state. Methods that merely use that state should be static as well.
	
## Calling Static Variable or Method

Usually, accessing a static member is easy. You just put the classname before the method or variable
and you are done. 

For example:

	System.out.println(Koala.count);
	Koala.main(new String[0]);
	
You can use an instance of the object to call a static method. The compiler checks for the type of the
reference and uses that instead of the object.

	Koala k = new Koala();
	System.out.println(k.count);          // k is a Koala
	k = null;
	System.out.println(k.count);          // k is still a Koala

## Static vs Instance.

A static member cannot call an instance member. This shouldn’t be a surprise since static doesn’t 
require any instances of the class to be around. 

	public class Static 
		{ 
		private String name = "Static class";
		public static void first() {  }
		public static void second() {  }
		public void third() 
			{  
			System.out.println(name);
		}  

		public static void main(String args[]) 
			{    
			first();
			second();
			third();          // DOES NOT COMPILE  
			}
		}
		
## Static Variables.	
