import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fast {

    public static void main(String[] args) {
        
        List<Point> points = readPoints("input6.txt");
        
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        
        Collections.sort(points);
        
        for (int i = 0; i < points.size(); i++) {
            Point origin = points.get(i);
            List<Point> copy = new ArrayList<Point>();
            for (int j = i+1; j < points.size(); j++) {
                copy.add(points.get(j));
            }
            Collections.sort(copy, origin.SLOPE_ORDER);
            for (int k = 0; k < copy.size()-2; k++) {
                if (copy.get(k).slopeTo(origin) == copy.get(k+1).slopeTo(origin)
                        && copy.get(k).slopeTo(origin) == copy.get(k+2).slopeTo(origin)) {
                    origin.drawTo(copy.get(k+2));
                    System.out.println(origin + " -> " + copy.get(k)
                            + " -> " + copy.get(k+1) + " -> " + copy.get(k+2));
                }
            }
        }
    }
    
    private static List<Point> readPoints(String fileName) {
        In file = new In(fileName);
        int numOfPoints = file.readInt();
        List<Point> points = new ArrayList<Point>(numOfPoints);
        while (file.hasNextLine()) {
            int x = file.readInt();
            int y = file.readInt();
            points.add(new Point(x, y));
        }
        return points;
    }
}
