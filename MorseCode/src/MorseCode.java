import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import org.w3c.dom.Node;

public class MorseCode
{
    private static final char DOT = '.';
    private static final char DASH = '-';

    private static TreeMap<Character, String> codeMap;
    private static TreeNode decodeTree;

    public static void main(String[] args)
    {
        MorseCode.start();  
        System.out.println(MorseCode.encode("Watson come here"));
        BTreePrinter.printNode(decodeTree);
    }

    public static void start()
    {
        codeMap = new TreeMap<Character, String>();
        decodeTree = new TreeNode(' ', null, null);  // autoboxing
        // put a space in the root of the decoding tree

        addSymbol('A', ".-");
        addSymbol('B', "-...");
        addSymbol('C', "-.-.");
        addSymbol('D', "-..");
        addSymbol('E', ".");
        addSymbol('F', "..-.");
        addSymbol('G', "--.");
        addSymbol('H', "....");
        addSymbol('I', "..");
        addSymbol('J', ".---");
        addSymbol('K', "-.-");
        addSymbol('L', ".-..");
        addSymbol('M', "--");
        addSymbol('N', "-.");
        addSymbol('O', "---");
        addSymbol('P', ".--.");
        addSymbol('Q', "--.-");
        addSymbol('R', ".-.");
        addSymbol('S', "...");
        addSymbol('T', "-");
        addSymbol('U', "..-");
        addSymbol('V', "...-");
        addSymbol('W', ".--");
        addSymbol('X', "-..-");
        addSymbol('Y', "-.--");
        addSymbol('Z', "--..");
        addSymbol('0', "-----");
        addSymbol('1', ".----");
        addSymbol('2', "..---");
        addSymbol('3', "...--");
        addSymbol('4', "....-");
        addSymbol('5', ".....");
        addSymbol('6', "-....");
        addSymbol('7', "--...");
        addSymbol('8', "---..");
        addSymbol('9', "----.");
        addSymbol('.', ".-.-.-");
        addSymbol(',', "--..--");
        addSymbol('?', "..--..");
    }

    /**
     * Inserts a word and its Morse code string into the encoding map
     * and calls treeInsert to insert them into the decoding tree.
     */
    private static void addSymbol(char word, String code)
    {
        codeMap.put(word, code);
        treeInsert(word, code);
    }

    /**
     * Inserts a word and its Morse code string into the
     * decoding tree.  Each dot-dash string corresponds to a path
     * in the tree from the root to a node: at a "dot" go left, at a "dash" go
     * right.  The node at the end of the path holds the symbol
     * for that code string.
     */
    private static void treeInsert(char word, String code) // fix later
    {
        TreeNode n = decodeTree;
        while (code.length() > 0){
            char l = code.charAt(0);
            if (l == DOT){
                if (n.getLeft() == null) n.setLeft(new TreeNode(' '));
                n = n.getLeft();
            }
            else{
                if (n.getRight() == null) n.setRight(new TreeNode(' '));
                n = n.getRight();
            } 
            code = code.substring(1);
        }
        n.setValue(word);
    }

    /**
     * Converts text into a Morse code message.  Adds a space after a dot-dash
     * sequence for each word.  Other spaces in the text are transferred directly
     * into the encoded message.
     * Returns the encoded message.
     */
    public static String encode(String text)
    {
        StringBuffer morse = new StringBuffer(400);
        text = text.toUpperCase();
        
        while (text.length() > 0){
            String add = codeMap.get(text.charAt(0));
            if (add == " ") morse.append(" ");
            else if (add != null) morse.append(add);
            text = text.substring(1);

            morse.append(" ");
        }
        
        
        /*
         while (text.length() > 1){
            if (text.charAt(0) == ' ')morse.append(" ");
            else{
            text = text.substring(1);

            //System.out.println(text);
            String add = codeMap.get(text.charAt(0));
            if (add != null)
                morse.append(add);
            }

            morse.append(" ");
            }

         */
        
        return morse.toString();
    }

    /**
     * Converts a Morse code message into a text string.  Assumes that dot-dash
     * sequences for each word are separated by one space.  Additional spaces are
     * transferred directly into text.
     * Returns the plain text message.
     */
    public static String decode(String morse)
    {   
        StringBuffer text = new StringBuffer(100);

        TreeNode node = decodeTree;
        for (char c : morse.toCharArray()){
            
            if (c == DOT) node = node.getLeft();
            else if (c == DASH) node = node.getRight();

            if (c == ' '){ //morse letters separated by spaces, so adds when at the end of the 'letter'
                text.append(node.getValue());
                node = decodeTree;
            }
        }
            return text.toString();
    }




/**
 * BTreePrinter class courtesy of Karen Ge (@karenge1)
 */
class BTreePrinter {

    public static void printNode(TreeNode root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.getValue());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.getLeft()), 
            BTreePrinter.maxLevel(node.getRight())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}
}
