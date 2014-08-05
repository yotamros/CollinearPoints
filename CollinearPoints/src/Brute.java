import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Brute {
    public static void main(String[] args) {
        
        String file = args[0];
        List<Point> points = readPoints(file);
        Collections.sort(points);
        
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        
        for (int i = 0; i < points.size(); i++) {
            for (int j = i+1; j < points.size(); j++) {
                for (int k = j+1; k < points.size(); k++) {
                    for (int l = k+1; l < points.size(); l++) {
                        Point p1 = points.get(i);
                        Point p2 = points.get(j);
                        Point p3 = points.get(k);
                        Point p4 = points.get(l);
                        if (p1.slopeTo(p2) == p1.slopeTo(p3) 
                                && p1.slopeTo(p3) == p1.slopeTo(p4)) {
                            p1.drawTo(p4);
                            System.out.println(points.get(i) + " -> "
                            + points.get(j) + " -> " + points.get(k) 
                            + " -> " + points.get(l));
                        }
                    }
                }
            }
        }
        System.out.println("done");
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
