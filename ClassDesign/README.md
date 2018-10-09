# Class Desing

Inheritance is the process by which the new child subclass automatically includes any public or protected primitives, objects, or methods defi ned in the parent class.

Java supports single inheritance, by which a class may inherit from only one direct parent class. Java also supports multiple levels of inheritance, by which one class may extend another class, which in turn extends another class. You can extend a class any number of times, allowing each descendent to gain access to its ancestor’s members. 

It is possible in Java to prevent a class from being extended by marking the class with the final modifi er. If you try to defi ne a class that inherits from a final class, the compiler will throw an error and not compile.

## Extending a Class.

In Java, you can extend a class by adding the parent class name in the defi nition using the extends keyword.

## Applying Class Access Modifiers

you should only be familiar with public and default package-level class access modifiers, because these are the only ones that can be applied to top-level classes within a Java file. The protected and private modifiers can only be applied to inner classes, which are classes that are defined within other classes.

The public access modifi er applied to a class indicates that it can be referenced and used in any class.

The default package private modifi er, which is the lack of any access modifi er, indicates the class can be accessed only by a subclass or class within the same package.

One feature of using the default package private modifi er is that you can defi ne many classes within the same Java file.

The rules for applying class access modifi ers are identical for interfaces. There can be at most one public class or interface in a Java fi le. Like classes, top-level interfaces can also be declared with the public or default modifiers.

## Creating Java Objects.

Throughout our discussion of Java in this book, we have thrown around the word object numerous times—and with good reason. In Java, all classes inherit from a single class, java.lang.Object.

Object is the only class that doesn’t have any parent classes. 

The compiler has been automatically inserting code into any class you write that doesn’t extend a specifi c class. 

For example, consider the following two equivalent class definitions.

	public class Zoo { }

	public class Zoo extends java.lang.Object { }

The key is that when Java sees you defi ne a class that doesn’t extend another class, it immediately adds the syntax extends java.lang.Object to the class defi nition. 

## Defining Constructors

Every class has at least one constructor. In the case that no constructor is declared, the compiler will automatically insert a default no-argument constructor.

In Java, the fi rst statement of every constructor is either a call to another constructor within the class, using this(), or a call to aconstructor in the direct parent class, using super(). 

Like the this() command that you saw in Chapter 4, the super() command may only be used as the fi rst statement of the constructor.

If the parent class has more than one constructor, the child class may use any valid parent constructor in its defi nition, as shown in the following example:

	public class Animal 
	{  
		private int age; 
		private String name;  
		public Animal(int age, String name) 
		{
			super();
			this.age = age;
			this.name = name;
		}

		public Animal(int age) 
		{
			super();
			this.age = age;
			this.name = null;
		}
	}

	public class Gorilla extends Animal {
		public Gorilla(int age) {
		super(age,"Gorilla");
		}

		public Gorilla() {
		super(5);
		}
	}

## Understanding Compiler Enhancements 

Up to now, we defi ned numerous classes that did not explicitly call the parent constructor via the super() keyword, so why did the code compile? The answer is that the Java compiler automatically inserts a call to the no-argument constructor super() if the fi rst statement is not a call to the parent constructor.

For example, the following three class and constructor defi nitions are equivalent, because the compiler will automatically convert them all to the last example:

	public class Donkey { 
	}

	public class Donkey {  
		public Donkey() {  
			}
	}

	public class Donkey {
	  	public Donkey() {
	  	   super();
	  	     }
	  	   }

What happens if the parent class doesn’t have a no-argument constructor? Recall that the no-argument constructor is not required and only inserted if there is no constructor defi ned in the class. In this case, the Java compiler will not help and you must create at least one constructor in your child class that explicitly calls a parent constructor via the super() command. For example, the following code will not compile:

	public class Mammal {  
		public Mammal(int age) {
		  } 
	}

	public class Elephant extends Mammal {  // DOES NOT COMPILE }	  	   	  	   

In this example no constructor is defi ned within the Elephant class, so the compiler tries to insert a default no-argument constructor with a super() call.

The compiler stops, though, when it realizes there is no parent constructor that takes no arguments. In this example, we must explicitly defi ne at least one constructor, as in the following code:

	public class Mammal {
	  public Mammal(int age) {
	    } 
	}

	public class Elephant extends Mammal {
	  public Elephant() {  // DOES NOT COMPILE  }
	   }	

This code still doesn’t compile, though, because the compiler tries to insert the noargument super() as the fi rst statement of the constructor in the Elephant class, and there is no such constructor in the parent class. We can fi x this, though, by adding a call to a parent constructor that takes a fi xed argument:

public class Mammal {
	  public Mammal(int age) {
	    } 
	}

	public class Elephant extends Mammal {
	  public Elephant() { 
	  	super(10);
	    }
	  }	

This code will compile because we have added a constructor with an explicit call to a parent constructor. Note that the class Elephant now has a no-argument constructor even though its parent class Mammal doesn’t. Subclasses may defi ne no-argument constructors even if their parent classes do not, provided the constructor of the child maps to a parent constructor via an explicit call of the super() command. 

Constructor Deﬁ nition Rules:

1. The first statement of every constructor is a call to another constructor within the class using this(), or a call to a constructor in the direct parent class using super(). 

2. The super() call may not be used after the first statement of the constructor.

3. If no super() call is declared in a constructor, Java will insert a no-argument super() as the first statement of the constructor. 

4. If the parent doesn’t have a no-argument constructor and the child doesn’t define any constructors, the compiler will throw an error and try to insert a default no-argument constructor into the child class. 

5. If the parent doesn’t have a no-argument constructor, the compiler requires an explicit call to a parent constructor in each child constructor.

## Calling Constructors.

 In Java, the parent constructor is always executed before the child constructor. For example, try to determine what the following code outputs:

	class Primate {
	  public Primate() {
	      System.out.println("Primate");  
	  } 
	}

	class Ape extends Primate {  
	public Ape() {
	    System.out.println("Ape");
	      } 
	  }

	public class Chimpanzee extends Ape {
	  public static void main(String[] args) {
	      new Chimpanzee(); 
	       } 
	   }

The code will execute with the parent constructors called fi rst and yields the following output:
Primate Ape

## Calling Inherited Class Members.

Java classes may use any public or protected member of the parent class, including methods, primitives, or object references. If the parent class and child class are part of the same package, the child class may also use any default members defi ned in the parent class. Finally, a child class may never access a private member of the parent class, at least not through any direct reference.

	class Fish {  
		protected int size;
		private int age; 
		public Fish(int age) {
		    this.age = age;  
		}   
		public int getAge() {
		    return age;  
		} 
	}

	public class Shark extends Fish {
	  	private int numberOfFins = 8;
	    public Shark(int age) {
	        super(age);
	        this.size = 4;
	            }

	    public void displaySharkDetails() {
	        System.out.print("Shark with age: "+getAge());          
	  		System.out.print(" and "+size+" meters long");
	  		System.out.print(" with "+numberOfFins+" fins");  
	      	} 
	      }

As you may remember from Chapter 4, you can use the keyword this to access a member of the class. You may also use this to access members of the parent class that are accessible from the child class, since a child class inherits all of its parent members. Consider the following alternative defi nition to the displaySharkDetails() method in the previous example:

	public void displaySharkDetails() {
	  System.out.print("Shark with age: "+this.getAge());
	  System.out.print(" and "+this.size+" meters long");
	  System.out.print(" with "+this.numberOfFins+" fins");
	  }

In Java, you can explicitly reference a member of the parent class by using the super keyword, as in the following alternative defi nition of displaySharkDetails():

	public void displaySharkDetails() {
	  System.out.print("Shark with age: "+super.getAge());
	  System.out.print(" and "+super.size+" meters long");
	  System.out.print(" with "+this.numberOfFins+" fins"); 
	}

In the previous example, we could use this or super to access a member of the parent class, but is the same true for a member of the child class? Consider this example:

	public void displaySharkDetails() {
	  System.out.print("Shark with age: "+super.getAge());
	  System.out.print(" and "+super.size+" meters long");
	  System.out.print(" with "+super.numberOfFins+" fins"); // DOES NOT COMPILE 
	}

This code will not compile because numberOfFins is only a member of the current class, not the parent class.

If the child class overrides a member of the parent class, this and super could have very different effects when applied to a class member.	

## Inheriting Methods

Inheriting a class grants us access to the public and protected members of the parent class, but also sets the stage for collisions between methods defi ned in both the parent class and the subclass..

## Overriding a Method .

What if there is a method defi ned in both the parent and child class? For example, you may want to defi ne a new version of an existing method in a child class that makes use of the defi nition in the parent class. In this case, you can override a method a method by declaring a new method with the signature and return type as the method in the parent class.

	public class Canine {  
	public double getAverageWeight() {
	    return 50;  
		} 
	}

	public class Wolf extends Canine {
	  public double getAverageWeight() {
	      return super.getAverageWeight()+20;  
	  }  
	  public static void main(String[] args) {
	    System.out.println(new Canine().getAverageWeight());
	    System.out.println(new Wolf().getAverageWeight());  
		} 
	}

In this example, in which the child class Wolf overrides the parent class Canine, the method getAverageWeight() runs without issue and outputs the following:

	50.00 
	70.00

Overriding a method is not without limitations, though. The compiler performs the following checks when you override a nonprivate method: 

1. The method in the child class must have the same signature as the method in the parent class.

2. The method in the child class must be at least as accessible or more accessible than the method in the parent class. 

3. The method in the child class may not throw a checked exception that is new or broader than the class of any exception thrown in the parent class method. 

4. If the method returns a value, it must be the same or a subclass of the method in the parent class, known as covariant return types.

	public class Camel {  
	protected String getNumberOfHumps() {
	    return "Undefined";  
		} 
	}

	public class BactrianCamel extends Camel {
	  private int getNumberOfHumps() { 
	   // DOES NOT COMPILE    return 2;  
		} 
	}

The code doesn't compile because breaks the rules 2 and 4.

public class InsufficientDataException extends Exception {
}

	public class Reptile {
	  protected boolean hasLegs() throws InsufficientDataException {
		  throw new InsufficientDataException();  
		  }  
	  
	  protected double getWeight() throws Exception { 
		  return 2;  
		  } 
	  }
	  

	public class Snake extends Reptile {
		  protected boolean hasLegs() {
		  return false;
	  }  
	  protected double getWeight() throws InsufficientDataException{
		  return 2;  
		  } 
	  }

This does not violate the third rule of overriding methods, though, as no new exception is defined.
In other words, a child method may hide or eliminate a parent method’s exception without issue. 

	public class Reptile {
	  protected boolean hasLegs() throws InsufficientDataException {
		  throw new InsufficientDataException();  
		  }  
	  
	  protected double getWeight(){ 
		  return 2;  
		  } 
	  }
	  

	public class Snake extends Reptile {
		  protected boolean hasLegs() throws Exception {
		  return false;
	  }  
	  protected double getWeight() throws InsufficientDataException {
		  return 2;  
		  } 
	  }

Unlike the earlier example, neither of the methods in the child class of this code will compile.
The getHeight() method in the parent class throws an InsufficientDataException, whereas the method
in the child class throws an Exception. Since Exception is not a subclass of InsufficientDataException,
the third rule of overriding methods is violated and the code will not compile. 
Coincidentally, Exception is a superclass of InsufficientDataException. 

Next, the getLength() method doesn’t throw an exception in the parent class, but it does throw an 
exception, InsufficientDataException, in the child class. In this manner, the child class defines
a new exception that the parent class did not, which is a violation of the third rule of overriding methods. 

## Redeclaring private Methods 

In Java, it is not possible to override a private method in a parent class since the parent method
is not accessible from the child class. Just because a child class doesn’t have access to the
parent method, doesn’t mean the child class can’t defi ne its own version of the method. 
It just means, strictly speaking, that the new method is not an overridden version of the parent
class’s method. 

## Hiding Static Methods.

A hidden method occurs when a child class defines a static method with the same name and signature as a static method 
defined in a parent class. 

First, the four previous rules for overriding a method must be followed when a method is hidden.
In addition, a new rule is added for hiding a method, namely that the usage of the static keyword 
must be the same between parent and child classes.

1. The method in the child class must have the same signature as the method in the parent class. 

2. The method in the child class must be at least as accessible or more accessible than the method 
in the parent class. 

3. The method in the child class may not throw a checked exception that is new or broader than 
the class of any exception thrown in the parent class method. 

4. If the method returns a value, it must be the same or a subclass of the method in the parent 
class, known as covariant return types. 

5. The method defined in the child class must be marked as static if it is marked as static in 
the parent class (method hiding). Likewise, the method must not be marked as static in the child class if it is not marked as static in the parent class (method overriding).

Examples.

	public class Bear {
	  public static void sneeze() {
	  System.out.println("Bear is sneezing");
	  }

	  public void hibernate() {
	  System.out.println("Bear is hibernating");
	  }
	 }
	  
	public class Panda extends Bear {
	  public void sneeze() {  // DOES NOT COMPILE    
	  System.out.println("Panda bear sneezes quietly");
	  }  
	  
	  public static void hibernate() {  // DOES NOT COMPILE
	  System.out.println("Panda bear is going to sleep");
	  } 
	 }
In this example, sneeze() is marked as static in the parent class but not in the child class. 
The compiler detects that you’re trying to override a method that should be hidden and generates
a compiler error. 

In the second method, hibernate() is an instance member in the parent class but a static method 
in the child class. In this scenario, the compiler thinks that you’re trying to hide a method that 
should be overridden and also generates a compiler error.
	 
## Overriding Vs Hiding

Unlike overriding a method, in which a child method replaces the parent method in calls defined 
in both the parent and child, hidden methods only replace parent methods in the calls defined in 
the child class.

Hidding Example

	public class Marsupial {
		public static boolean isBiped() {
			return false;  
			}  
		
		public void getMarsupialDescription() {
			System.out.println("Marsupial walks on two legs: "+isBiped());  
			} 
		}

	public class Kangaroo extends Marsupial {
		public static boolean isBiped() {
			return true;  
		}  
		
		public void getKangarooDescription() {
			System.out.println("Kangaroo hops on two legs: "+isBiped());
		}  
	
	public static void main(String[] args) {
		Kangaroo joey = new Kangaroo();    
		joey.getMarsupialDescription();    
		joey.getKangarooDescription();  
		}
	}
 
The output is 

Marsupial walks on two legs: false
Kangaroo hops on two legs: true

As you can see in the Hidden examaple the first method call the parent method and the second calls
the child method.

Overriding Example

	public class Marsupial {
		public boolean isBiped() {
			return false;  
			}  
		
		public void getMarsupialDescription() {
			System.out.println("Marsupial walks on two legs: "+isBiped());  
			} 
		}

	public class Kangaroo extends Marsupial {
		public boolean isBiped() {
			return true;  
		}  
		
		public void getKangarooDescription() {
			System.out.println("Kangaroo hops on two legs: "+isBiped());
		}  
	
	public static void main(String[] args) {
		Kangaroo joey = new Kangaroo();    
		joey.getMarsupialDescription();    
		joey.getKangarooDescription();  
		}
	}
 
The output is 

Marsupial walks on two legs: true
Kangaroo hops on two legs: true

As you can see in the Overriding examaple both, the first and second method call to the child method.

## Creating Final Methods.

We conclude our discussion of method inheritance with a somewhat self-explanatory rule: final methods cannot be overridden. 

This rule is in place both when you override a method and when you hide a method. In other words, you cannot hide a static method in a parent class if it is marked as final. 

	public class Bird {  
	public final boolean hasFeathers() {
		return true;  
		} 
	}

	public class Penguin extends Bird {
	  public final boolean hasFeathers() { // DOES NOT COMPILE
	  return false;  
	  } 
	} 

The final keyword in the Child is irrelevant—the code will not compile either way.

## Inheriting Variables

Luckily, the rules for variables with the same name in the parent and child classes are a lot 
simpler, because Java doesn’t allow variables to be overridden but instead hidden.

## Hiding Variables.

When you hide a variable, you defi ne a variable with the same name as a variable in a parent class.
This creates two copies of the variable within an instance of the child class: 
one instance defined for the parent reference and another defined for the child reference.

As when hiding a static method, you can’t override a variable; you can only hide it. Also similar 
to hiding a static method, the rules for accessing the parent and child variables are quite similar.
If you’re referencing the variable from within the parent class, the variable defined in the 
parent class is used. Alternatively, if you’re referencing the variable from within a child class,
the variable defi ned in the child class is used.

	public class Rodent {  
			protected int tailLength = 4;
			public void getRodentDetails() {
			System.out.println("[parentTail="+tailLength+"]");
			} 
		}	
	
	public class Mouse extends Rodent {
		  protected int tailLength = 8;
		  public void getMouseDetails() {
		  System.out.println("[tail="+tailLength +",parentTail="+super.tailLength+"]");
	  }  
	  
	  public static void main(String[] args) {
		  Mouse mouse = new Mouse();    
		  mouse.getRodentDetails();
		  mouse.getMouseDetails();
		  }
	  }

Output.

[parentTail=4]
[tail=8,parentTail=4]

As you can see the variables are hidden but not overridden.

Although Java allows you to hide a variable deﬁned in a parent class with one deﬁned in a child
class, it is considered an extremely poor coding practice. For example, take a look at the
following code, which uses a hidden variable length, marked as public in both parent and child
classes.

Hiding variables makes the code very confusing and difﬁcult to read, especially if you start 
modifying the value of the variable in both the parent and child methods, since it may not be 
clear which variable you’re updating.

## Creating Abstract Classes

An abstract class is a class that is marked with the abstract keyword and cannot be instantiated.
An abstract method is a method marked with the abstract keyword defined in an abstract class,
for which no implementation is provided in the class in which it is declared. 

	public abstract class Animal {
	  protected int age;  public void eat() {
	  System.out.println("Animal is eating");
	  }  
	  
	  public abstract String getName();
	  }

	public class Swan extends Animal {
	  public String getName() {
		  return "Swan";
			} 
	  }
	  
## Defining an Abstract Class

1. An abstract class may include non abstract methods and variables.

2. An abstract class is not required to include any abstract methods.

3. An abstract method may only be defined in an abstract class.

4. You can’t provide a default implementation to an abstract method in an abstract class, 
you can still deﬁne a method with a body—you just can’t mark it as abstract. 

5. An abstract class cannot be marked as final for a somewhat obvious reason. By definition,
an abstract class is one that must be extended by another class to be instantiated, 
whereas a final class can’t be extended by another class. By marking an abstract class as final, 
you’re saying the class can never be instantiated, so the compiler refuses to process the code

	public final abstract class Tortoise {  // DOES NOT COMPILE }

6. An abstract method may not be marked as final for the same reason that an abstract class may
not be marked as final. Once marked as final, the method can never be overridden in a subclass, 
making it impossible to create a concrete instance of the abstract class.

7. Finally, a method may not be marked as both abstract and private. How would you define a 
subclass that implements a required method if the method is not accessible by the subclass itself.

	public abstract class Whale {  private abstract void sing();  // DOES NOT COMPILE }
	
## Creating a Concrete Class.

A concrete class is the first non-abstract subclass that extends an abstract class and is required
to implement all inherited abstract methods. 

When you create a concrete class, all the abstract parent method must be implement.

	public abstract class Animal {  
		public abstract String getName(); 
		}

	public class Bird extends Animal { // DOES NOT COMPILE }

	public class Flamingo extends Bird {
	  public String getName() {
	  return "Flamingo";  
	  }
	}
	
## Extending an Abstract Class

	public abstract class Animal {  
		public abstract String getName();
		}
		
	public class Walrus extends Animal {
	 // DOES NOT COMPILE 
	 }

	public abstract class Eagle extends Animal {
	 }

As you saw in this example, abstract classes can extend other abstract classes and are not required
to provide implementations for any of the abstract methods. It follows, then, that a concrete class
that extends an abstract class must implement all inherited abstract methods. For example:

	public abstract class Animal {
		public abstract String getName();
	  }
	  
	public abstract class BigCat extends Animal {
		public abstract void roar(); 
	  }
	  
	public class Lion extends BigCat {
		public String getName() {    
		return "Lion";  
		}
		
		public void roar() {
		System.out.println("The Lion lets out a loud ROAR!");
	} 
		
There is one exception to the rule for abstract methods and concrete classes: a concrete subclass 
is not required to provide an implementation for an abstract method if an intermediate abstract 
class provides the implementation.

	public abstract class Animal {
		public abstract String getName();
	  }
	  
	public abstract class BigCat extends Animal {
		public String getName() {    
			return "Big Cat";  
		}
		
		public abstract void roar(); 
	  }
	  
	public class Lion extends BigCat {
			
		public void roar() {
		System.out.println("The Lion lets out a loud ROAR!");
	}
	
## Abstract Class Deﬁ nition Rules

1. Abstract classes cannot be instantiated directly. 

2. Abstract classes may be defined with any number, including zero, of abstract and nonabstract methods. 

3. Abstract classes may not be marked as private or final. 

4. An abstract class that extends another abstract class inherits all of its abstract methods as its own abstract methods. 

5. The first concrete class that extends an abstract class must provide an implementation for all of the inherited abstract methods.

## Abstract Method Deﬁ nition Rules

1. Abstract methods may only be defined in abstract classes. 

2. Abstract methods may not be declared private or final. 

3. Abstract methods must not provide a method body/implementation in the abstract class for which is it declared. 

4. Implementing an abstract method in a subclass follows the same rules for overriding a method. For example, the name and signature must be
the same, and the visibility of the method in the subclass must be at least as accessible as the method in the parent class.

