import java.util.Stack;

/**
 * This program simulates an undo stack. Note that operations
 * must be undone in the opposite order in which they are first
 * issued.
*/
public class StackDemo
{
    public static void main(String[] args)
    {
        Stack<String> commands = new Stack<>();

        // push a bunch of commands onto the top of the stack
        commands.push("Insert: 'Hello'");
        commands.push("Insert: ','");
        commands.push("Insert: '.'");
        commands.add("Insert: 'world'");
        commands.add("Insert: '?'");
        commands.push("Delete: '?'");
        commands.push("Insert: '!'");

        System.out.println(commands); // top of the stack is the far right

        //simulate pressing undo 4 times
        commands.pop();
        commands.pop();
        commands.pop();
        commands.pop();

        System.out.println(commands);
    }
}
