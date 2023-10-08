import java.util.Stack;

public class Grid
{
    private static final int SIZE = 10;
    private int[][] pixels = new int[SIZE][SIZE];
    private Stack<Pair> stack = new Stack<>();
    int count = 1;
    int adjacent = 0;
    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        stack.add(new Pair(row, column));
        pixels[row][column] = 1;
        
        while (stack.size() > 0){
            boolean north = false;
            boolean south = false;
            boolean east = false;
            boolean west = false;
            Pair point = stack.pop();
            int x = point.getRow();
            int y = point.getColumn();
            if (y < 9 && pixels[x][y+1] == 0){
                count++;
                pixels[x][y+1] = count;
                south = true;
                
            }
            if (y > 0 && pixels[x][y-1] == 0){
                count++;
                pixels[x][y-1] = count;
                north = true;
                
            }
            if (x < 9 && pixels[x+1][y] == 0 ){
                count++;
                pixels[x+1][y] = count;
                east = true;
                
            }
            
            if (x > 0 &&pixels[x-1][y] == 0){
                count++;
                pixels[x-1][y] = count;
                west = true;
                
            }
            if (west)stack.push(new Pair(x-1, y));
            if (east)stack.push(new Pair(x+1, y));
            if (north)stack.push(new Pair(x, y-1));
            if (south)stack.push(new Pair(x, y+1));
            
            
            
            
            }
        }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++){
                //System.out.println(pixels[i][j]);
                r = r + String.format("%4d", pixels[i][j]);
            }
            r = r + "\n";
        }
        return r;
    }
}
