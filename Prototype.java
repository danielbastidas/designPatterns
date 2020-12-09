/** When it is easier to copy an existing object to fully initialize a new
 * one.
 * Object copying of complicated objects
 * Deep copying/cloning.
 * A partially or fully initialized object that you copy (clone) and make use
 * of
 * It is a creational pattern
 */
class Scratch {
    public static void main(String[] args) {
        
    }
}

class Point
{
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Line
{
    public Point start, end;

    public Line(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy()
    {
        return new Line(new Point(start.x, start.y), new Point(end.x, end.y));
    }
}
