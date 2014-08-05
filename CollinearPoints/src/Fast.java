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
            List<Point> toCheck = new ArrayList<Point>();
            for (int j = i+1; j < points.size(); j++) {
                toCheck.add(points.get(j));
            }
            Collections.sort(toCheck, origin.SLOPE_ORDER);
            for (int k = 0; k < toCheck.size()-2; k++) {
                if (toCheck.get(k).slopeTo(origin) == toCheck.get(k+1).slopeTo(origin)
                        && toCheck.get(k).slopeTo(origin) == toCheck.get(k+2).slopeTo(origin)) {
                    origin.drawTo(toCheck.get(k+2));
                    System.out.println(origin + " -> " + toCheck.get(k)
                            + " -> " + toCheck.get(k+1) + " -> " + toCheck.get(k+2));
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
