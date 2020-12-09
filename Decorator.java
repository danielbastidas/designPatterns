/** Adding behavior without altering the class itself.
 * Facilitates the addition of behaviors to individual objects without
 * inheriting from them
 * It is a structural pattern
 * For instance when you use the Java IO api when you are creating a reader
 * on top of a input stream
 * */
class Scratch {
    public static void main(String[] args) {
        
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
        this.bird.age = age;
        this.lizard.age = age;
        this.age = age;
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