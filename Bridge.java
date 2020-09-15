/** Connecting components together  through abstractions.
 * Prevents cartesian product or complexity explosion
 * Avoids entity explosion on a class hierarchy.
 * a mechanism that decouples an interface (hierarchy) from an implementation
 * (hierarchy)
 *  */
class Scratch {
    public static void main(String[] args) {
        System.out.println(new Triangle(new RasterRenderer()).toString());
    }
}

abstract class Shape
{
    Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract String getName();

    @Override
    public String toString()
    {
        return String.format("Drawing %s %s",getName(),
                renderer.whatToRenderAs());
    }
}

class Triangle extends Shape
{

    public Triangle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName()
    {
        return "Triangle";
    }

}

class Square extends Shape
{

    public Square(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName()
    {
        return "Square";
    }

}

class RasterRenderer implements Renderer
{
    @Override
    public String toString()
    {
        return "as pixels";
    }

    @Override
    public String whatToRenderAs() {
        return toString();
    }
}

class VectorRenderer implements Renderer
{
    @Override
    public String toString()
    {
        return "as lines";
    }

    @Override
    public String whatToRenderAs() {
        return toString();
    }
}

interface Renderer {
    public String whatToRenderAs();
}