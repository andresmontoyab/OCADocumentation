# Java Building Blocks

## Fields and Methods

	1. Java classeshave two primary elements: methods(Function or Procedures) and Fields(variables).
	2. Variables hold the state of the program.
	3. Methods operate on that state.
	
## Fields.

The structure of the field is the next Accesor Type nameVariable;

	1. public String name;
	2. private String name;
	
## Methods.

The structure of the method is the next Accesor ReturnType MethodName(Parameters...) { Body }

	1. public String getName(){
			return name;
		}
		
	2. public void setName(String newName) {
		name = newName;
	}
	
The full declaration of a method is called a method Signature.

	3. public int numberVisitor(int month) -> has return type and parameter.
	
## Comments

Comments are not executable code, you can place them anywhere. There are three types of comments on
java.

	1. Single Line Comments "//" Coment until end of line.
	2. Multiple Line Comments /* Multiple Comment */ -> Include anything that is between the symbols /* and */
	3. Javadoc Comment is similar to miltiline comment but start with /**
	
## Classes Vs Files

Java class is defined in its own *.java file. It's usually public, which mean any code can call it.
Interestingly, java does not require that the class be public.

The next example is valid but is not a public class, so only the classes in the same package can use it.

		class Animal {
		}

You can even put two classes in the same File , when you do so, at most one of the classes in the fileis allowed to be public.
That means a file containing the following is also fine.

		public class Animal {
			private String name;
		}

		class Animal2{
		}
		
The public class must match with the file name.

## Writing a main() method.

A main() method is the gateway between the startup of a Java process , which is managed by the JVM and
the beggining of the programmer's code. The JCM calls on the underlying system to allocate memory and CPU time.

		public class Main {

			public static void main(String[] args) {

			}
		}	
		
Be sure that the method main always be public static void main(String[] args)

##Package Declaration

package some.thing.package --> C:/Projects/src/java/some/thing/package

Import statements

Traer clases de afuera.

import java.util.List;
import some.package.MyCustomClass;
import some.package.*

## Constructores and instance initializers

Constructor es un metodo especial y no requiere un tipo de retorno y tiene el mismo nombre de laclase.

Un inicalizador de instancia es un bloque definito de codigo que no tiene una firma de metodo, 
 { doSomething();}
 
 Primero la creacion del objeto
 Despues instance initializers
 El resto
 
## Tipos Primitivos

boolean
byte
short
int 
long 
float
double
chart
	
A los primero no se les pueden asignar null y no tienen metodos.


Tipos por referencia

Para crear una instancia de un tipo por referencia se usa la parabla new junto con el nombre de la clase.

Identificadores Valid

Deben comenzar con una letra
Despues del primer caracter el nombre puede contener numeres.
Ademas el nombre no puede ninguna de las palabras reservadas de java.

##Scope variables

Variables declaradas dentro de un bloque, if o lambda son solo validaas dentro de él.
Ademas las variables declardasa en un loop for , solo son validas dentro del for.

## Garbage collector y destruccion de objetos.

Detecta si la variable no se esta utilizanda, si ya fue utilizada y la libera.

System.gc()

Todos los tipos por refencia tiene una metodo finalize(), este metodo se puede sobreescribrir para realizar
el limpiado.

## Question Book.