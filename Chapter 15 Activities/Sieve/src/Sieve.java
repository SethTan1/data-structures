import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        //. . .
        HashSet<Integer> nums = new HashSet<>();
        HashSet<Integer> removeNums = new HashSet<>();
        // init set with values of every number from 2 to n
        // start with 2 (or whatever prime number were on) and remove all multiples in the set
        // once all multiples up to n are removed, the next number in the set should be prime and remove all the multiples of that
        // once there are no more numbers to remove, print the set and it should only be prime numbers

        for (int i = 2; i < n; i++)
            nums.add(i);


        Iterator<Integer> primeIterator = nums.iterator(); // this should only iterate over prime numbers
        System.out.println(primeIterator.next());
        for (int i = 2; i < n && primeIterator.hasNext(); i = primeIterator.next() )// somehow advance to next number in set)
        {
            System.out.println("i="+i);
            for (int j = 2*i; j < n; j += i)
            {
                System.out.println(j+" removed");
                removeNums.add(j);
            }
        }
        nums.removeAll(removeNums);
        System.out.println("The set is: " + nums.toString());

    }

}