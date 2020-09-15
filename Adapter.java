/** Converts from one interface to another.
 * Getting the interface you want from the interface you have.
 * A construct which adapts an existing interface X to conform the required
 * interface Y  */
class Scratch {
    public static void main(String[] args) {
        
    }
}

class Square
{
    public int side;

    public Square(int side)
    {
        this.side = side;
    }
}

interface Rectangle
{
    int getWidth();
    int getHeight();

    default int getArea()
    {
        return getWidth() * getHeight();
    }
}

class SquareToRectangleAdapter implements Rectangle
{
    Square square;
    public SquareToRectangleAdapter(Square square)
    {
        this.square = square;
    }

    @Override
    public int getWidth() {
        return square.side;
    }

    @Override
    public int getHeight() {
        return square.side;
    }

}