import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Map<String, String> map = new TreeMap<>(); 

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
                System.out.println("What is the name of the student you want to add?");
                String nameinput = in.next();
                System.out.println("What is the grade of the student?");
                String grade = in.next();
                map.put(nameinput, grade);

            } else if (input.equals("R"))
            {
                System.out.println("What is the name of the student you want to remove?");
                String nameinput = in.next();
                map.remove(nameinput);
            } else if (input.equals("M"))
            {
                System.out.println("What is the name of the student you want to modify?");
                String nameinput = in.next();
                System.out.println("What do you want to set the grade to?");
                String grade = in.next();
                map.put(nameinput, grade);
            } else if (input.equalsIgnoreCase("P"))
            {
                for (String key: map.keySet()){
                    System.out.println("Name: "+ key + " Grade: "+map.get(key));
                }
            } else
            {
                done = true;
            }
        }
    }
}
