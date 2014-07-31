import java.util.Comparator;

public class Point implements Comparable<Point> {
    
    /*
     * Compare points by slope to this point
     */
    public final Comparator<Point> SLOPE_ORDER; {
    }
    
    private final int x;
    private final int y;
    
    /*
     * Construct the point (x, y)
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /*
     * Draw this point
     */
    public void draw() {
        StdDraw.point(x, y);
    }
    
    /*
     * Draw the line segment from this point to that point
     */
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }
    
    /*
     * (non-Javadoc) String representation
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    /*
     * (non-Javadoc) Is this point lexicographically smaller than that point?
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Point that) {
        return 0;
    }
    
    /*
     * The slope between this point and that point
     */
    public double slopeTo(Point that) {
        return 0;
    }
    
    public static void main(String[] args) {
    }
}