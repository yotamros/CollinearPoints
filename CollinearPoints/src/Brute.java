import java.util.ArrayList;


public class Brute {

    public static void main(String[] args) {

        In file = new In("input10.txt");
        ArrayList<Integer> points = new ArrayList<Integer>();
        
        while (file.hasNextLine()) {
            points.add(file.readInt());
        }
        
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        

        for (int i=1; i<points.size()-1; i += 2) {
            Point point1 = new Point(points.get(i), points.get(i+1));
            for (int j = i+2; j<points.size()-1; j += 2) {
                Point point2 = new Point(points.get(j), points.get(j+1));
                for (int k = j+2; k<points.size()-1; k += 2) {
                    Point point3 = new Point(points.get(k), points.get(k+1));
                    for (int m = k+2; m<points.size()-1; m += 2) {
                        Point point4 = new Point(points.get(m), points.get(m+1));
                        System.out.println();
                        System.out.println("---");
                        if (point1.slopeTo(point2) == point1.slopeTo(point3) && 
                                point1.slopeTo(point2) == point1.slopeTo(point4)) {
                            System.out.println("point " + i + " to point " + (j) + ": " + point1.slopeTo(point2));
                            System.out.println("point " + i + " to point " + (k) + ": " + point1.slopeTo(point3));
                            System.out.println("point " + i + " to point " + (m) + ": " + point1.slopeTo(point4));
                            point1.drawTo(point4);
                        }
                    }
                }
            }
            
        }
        System.out.println("done");
        
    }

}
