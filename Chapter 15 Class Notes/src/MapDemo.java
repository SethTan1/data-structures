import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        //map interface is generic
        //key and value

        Map<String, Color> favColors = new HashMap<>();

        // add elements to a map using the put method
        favColors.put("Peter", Color.BLACK);
        favColors.put("Seth", Color.blue);
        favColors.put("Celeste", Color.orange);

        // Two different keys can have the same value
        favColors.put("Dr. Miller", Color.orange);

        // the same key cannot have two different values
        favColors.put("Peter", Color.yellow);
        // replaces black with yellow

        Set<String> keys = favColors.keySet();
        for (String s : keys){
            System.out.println(s+ " ("+ s.hashCode()+ "): "+ favColors.get(s) );

        }

    }
}
