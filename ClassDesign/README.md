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













