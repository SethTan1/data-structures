import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities/HTMLChecker/src/TagSample2.html";
        Stack<String> stack = new Stack<>();
        //Stack<String> temp = new Stack<>();
        //Stack<String> reverse = new Stack<>();
        try (Scanner in = new Scanner(new File(filename)))
        {
            // Your code goes here
            while (in.hasNext()){
                String next = in.next();
                stack.push(next);
                //temp.push(next);
            }
            /* 
            while (temp.size() > 0){
                reverse.push(temp.pop());
            }
            */
            int flag = 0;
            for (String s : stack){
                
                String letter = "/"+s.substring(1, s.length()-1);
                for (String s2 : stack){
                        String letter2 = s2.substring(1, s2.length()-1);
                        //System.out.println(letter2);
                    System.out.println(s + " " + s2+ " " + letter +" "+ letter2);
                    if (letter.equals(letter2)){
                            flag ++;
                    }
                }
            }
            if (flag == stack.size()/2) System.out.println("The sequence is properly nested");
            else System.out.println("The sequence is not properly nested");
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
