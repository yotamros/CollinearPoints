import java.util.Comparator;

public class Point implements Comparable<Point> {
    
    /*
     * Compare points by slope to this point
     */
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {

        public int compare(Point o1, Point o2) {
            return Double.compare(o1.slopeTo(o1), o2.slopeTo(o2));
        }
        
    };
    
    private final int x;
    private final int y;
    
    /*
     * Construct the point (x, y)
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }
    
    /*
     * Draw this point
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }
    
    /*
     * Draw the line segment from this point to that point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }
    
    /*
     * (non-Javadoc) String representation
     * @see java.lang.Object#toString()
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }
    
    /*
     * (non-Javadoc) Is this point lexicographically smaller than that point?
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Point that) {
        if (this.y == that.y) {
            return Integer.compare(this.x, that.x);
        }
        return Integer.compare(this.y, that.y);
    }
    
    /*
     * The slope between this point and that point
     */
    public double slopeTo(Point that) {
        double posInf = Double.POSITIVE_INFINITY; 
        double negInf = Double.NEGATIVE_INFINITY;
        if ((that.y-this.y) == 0) {
            return posInf;
        } else if ((that.x-this.x) == 0) {
            return +0;
        } else if (((that.y-this.y) == 0) && ((that.x-this.x) == 0)) {
            return negInf;
        }
        return (that.y-this.y)/(that.x-this.x);
    }
    
    public static void main(String[] args) {
    }
}