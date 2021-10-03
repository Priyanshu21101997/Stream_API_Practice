import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class demo {
    public static void doubleIt(int num){
        System.out.println(num*2);
    }
    public static void main (String[] args){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);

        //1) Normal calling using lambda and method reference

       // list.forEach(i-> System.out.println(i));  // For each using lambda

        // Calling using method reference

       // list.forEach(System.out::println);

        //2)  Calling a function using lambda and method reference

        //list.forEach(i->doubleIt(i)); // Using lambda

        //list.forEach(demo::doubleIt) ;  //class::method

        // WORKING WITH STREAMS

        //1. Stream , map , reduce

        Stream<Integer> s = list.stream(); // Converts into stream
        Stream<Integer> s1 = s.map(i -> i*2); // Applies some logic to each value
        Integer result = (Integer)s1.reduce(0,(i,j)->i+j); // So 0 is like a result variable , i,j are input and we are adding both using i+j and assigning bCK IN 0

        System.out.println(result);

        // OR in 1 line we can do it by

        System.out.println(list.stream().map(i->i*2).reduce(0,(i,j)->i+j));

        // 2. Pre-built methods in reduce

        System.out.println(list.stream().map(i->i*2).reduce(0,(i,j)->Integer.sum(i,j)));
        //By method reference

        System.out.println(list.stream().map(i->i*2).reduce(0,Integer::sum));

        //3.Filter method -> Filters values based on predicate/condition

        System.out.println(list.stream().filter(i->i>6).reduce(0,(i,j)->i+j));

        //4.FindFirst method -> Find first element according to our condition ie divisible by 5
        // By default our output will be Optional[5] bcoz if we are not able to find anything divisible by 5 then it reduces bug by showing Optional.empty
        // but we can remove optional by using ORELSE

        System.out.println(list.stream().filter(i->i%5==0).findFirst()); // Optional.[5] output , if not found Optional.empty
        System.out.println(list.stream().filter(i->i%5==0).findFirst().orElse(0)); // Remove optional op is 5 if found otherwise 0




    }
}
