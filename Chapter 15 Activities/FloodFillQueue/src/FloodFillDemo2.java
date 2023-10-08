
public class FloodFillDemo2 
{
    public static void main(String[] args)
    {
        Grid2 gr = new Grid2();
        gr.floodfill(3, 4);
        System.out.println(gr.toString());
    }
}
