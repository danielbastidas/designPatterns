/** An interface for accessing a particular resource.
 * A class that functions as an interface to a particular resource. That
 * resource may be remote, expensive to construct, or may require logging or
 * some other added functionality */
class Scratch {
    public static void main(String[] args) {
        Dragon dragon =new Dragon();
        dragon.setAge(11);
        System.out.println(dragon.fly());
    }
}

class Bird
{
    public int age;

    public String fly()
    {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard
{
    public int age;

    public String crawl()
    {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon
{
    private int age;
    private Bird bird;
    private Lizard lizard;

    public Dragon() {
        this.bird = new Bird();
        this.lizard = new Lizard();
    }

    public Dragon(int age) {
        this.bird = new Bird();
        this.lizard = new Lizard();
        setAge(age);
    }

    public void setAge(int age)
    {
        this.age = age;
        bird.age = age;
        lizard.age = age;
    }
    public String fly()
    {
        return bird.fly();
    }
    public String crawl()
    {
        return lizard.crawl();
    }
}