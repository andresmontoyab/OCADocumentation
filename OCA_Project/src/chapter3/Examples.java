package chapter3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Examples {


    public static void main(String[] args) {

        //questionOne();
        //questionTwo();
        //questionFour();
        //questionFive();
        //questionSix();
        //questionSeven();
        //questionEight();
        //questionNine();
        //questionTen();
        //questionEleven();
        //questionTwelve();
        //questionTwentyOne();
        questionTwentyTwo();
        //questionTwentyThree();
        //questionTwentySix();
        //questionTwentyNine();
        //questionThirty();
        // questionThirtyOne();
        // questionThirtyTwo();
        // questionThirtyThree();

    }

    private static void questionThirtyThree() {
        System.out.println("This is the question 33");
        LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        Period p = Period.ofDays(1).ofYears(2);
        d = d.minus(p);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(f.format(d));
    }

    private static void questionThirtyTwo() {
        LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        Period p = Period.of(1, 2, 3);
        d = d.minus(p);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(d.format(f));
    }

    private static void questionThirtyOne() {
        LocalDate date = LocalDate.of(2018, Month.APRIL, 30);
        date.plusDays(2);
        date.plusYears(3);
        System.out.println(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());
    }

    private static void questionThirty() {
        LocalDate date = LocalDate.of(2018, Month.APRIL, 40);
        System.out.println(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());
    }

    private static void questionTwentyNine() {
        System.out.println("This is the question 29");
        LocalDate date = LocalDate.parse("2018-04-30", DateTimeFormatter.ISO_LOCAL_DATE);
        date.plusDays(2);
        //date.plusHours(3);
        System.out.println(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());
    }

    private static void questionTwelve() {
        StringBuilder numbers = new StringBuilder("0123456789");
        numbers.delete(2,  8);   // 0189
        numbers.append("-").insert(2, "+"); //018+9-
        System.out.println(numbers);
    }

    private static void questionEleven() {
        System.out.println("This is the question 11");
        int total = 0;
        StringBuilder letters = new StringBuilder("abcdefg");
        total += letters.substring(1, 2).length();
        total += letters.substring(6, 6).length();
        total += letters.substring(6, 5).length(); // If strat > end the substring impl throw a class.
        System.out.println(total);
    }

    private static void questionTen() {
        System.out.println("This is the question 10");
        String a = "";
        a += 2;
        a += 'c';
        a += false;
        if ( a == "2cfalse") System.out.println("==");
        if ( a.equals("2cfalse")) System.out.println("equals");
    }

    private static void questionTwentyThree() {
        System.out.println("This is the question 23");
        List<Integer> list = Arrays.asList(10, 4, -1, 5);
        Collections.sort(list);
        Integer array[] = list.toArray(new Integer[4]);
        System.out.println(array[0]);
    }

    private static void questionNine() {
        System.out.println("This is the question 9");
        String s = "purr";
        s.toUpperCase();
        s.trim();
        s.substring(1, 3);
        s += " two";
        System.out.println(s.length());
    }

    private static void questionEight() {
        System.out.println("This is the question 8");
        String numbers = "012345678";
        System.out.println(numbers.substring(1, 3));
        System.out.println(numbers.substring(7, 7));
        System.out.println(numbers.substring(7));
    }

    private static void questionSeven() {
        System.out.println("This is the question 7");
        String letters = "abcdef";
        System.out.println(letters.length());
        System.out.println(letters.charAt(3));
        System.out.println(letters.charAt(6));
    }

    private static void questionTwentyTwo() {
        System.out.println("This is the question 22");
        int[] random = { 6, -4, 12, 0, -10 };
        int x = 12;
        int y = Arrays.binarySearch(random, x);
        System.out.println(y);
    }

    private static void questionTwentyOne() {
        System.out.println("This is the question 21");
        ArrayList<Integer> values = new ArrayList<>();
        values.add(4);
        values.add(5);
        values.set(1, 6);
        values.remove(0);
        for (Integer v : values) System.out.print(v);
    }

    private static void questionFive() {
        System.out.println("This is the question 5");
        String s1 = "java";
        StringBuilder s2 = new StringBuilder("java");
        //if (s1 == s2) // DOES not compile because are differente types of objects
        System.out.print("1");
        if (s1.equals(s2))
            System.out.print("2");
    }

    private static void questionFour() {
        System.out.println("This is the question 4");
        StringBuilder sb = new StringBuilder();
        sb.append("aaa").insert(1, "bb").insert(4, "ccc");
        System.out.println(sb);
        // abbaccca
    }

    private static void questionTwentySix() {
        System.out.println("This is the question 26");
        List<Integer> ages = new ArrayList<>();
        int aux =Integer.parseInt("5");
        ages.add(aux);
        ages.add(Integer.valueOf("6"));
        ages.add(7);
        ages.add(null);
        for (int age : ages) {
            System.out.print(age);
        }

        // The code compiles
        // The code throws a runtime Exception.
        //
    }

    private static void questionTwo() {

        System.out.println(" This is the Question 2");
        String s = "Hello";                         // String Pool
        String t = new String(s);                   // Object in the heap.
        if ("Hello".equals(s)) System.out.println("one");   // True because the literal "Hello" has the same values of the Literal s
        if (t == s) System.out.println("two");              // False cause is queality referencial and one is pooled and the other is in the heap
        if (t.equals(s)) System.out.println("three");       // True, check values
        if ("Hello" == s) System.out.println("four");       // True
        if ("Hello" == t) System.out.println("five");       // False
    }

    private static void questionOne() {
        System.out.println("This is the question 1");
        // What is output by the following code? (Choose all that apply)
        int numFish = 4;
        String fishType = "tuna";
        //String anotherFish = numFish + 1; // This line produce a error because the return type is int but the type is Strng
        //System.out.println(anotherFish + " " + fishType);
        System.out.println(numFish + " " + 1);
    }
    private static void questionSix() {
        System.out.println("This is the question Six");
        String roar1 = "roar";
        StringBuilder roar2 = new StringBuilder("roar");
        new Lion().roar(roar1, roar2);
        System.out.println(roar1 + " " + roar2);
    }
}

class Lion {
    public void roar(String roar1, StringBuilder roar2) {
        roar1.concat("!!!");
        roar2.append("!!!");
    }


}


