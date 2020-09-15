/** A high-level blueprint for an algorithm to be completed by inheritors.
 * Template pattern does the same as Strategy pattern through inheritance.
 * Allows us to define the skeleton of the algorithm, with concrete
 * implementations defined  in subclasses.*/
class Scratch {
    public static void main(String[] args) {
        
    }
}

class Creature
{
    public int attack, health;

    public Creature(int attack, int health)
    {
        this.attack = attack;
        this.health = health;
    }
}

abstract class CardGame
{
    public Creature [] creatures;

    public CardGame(Creature[] creatures)
    {
        this.creatures = creatures;
    }

    // returns -1 if no clear winner (both alive or both dead)
    public int combat(int creature1, int creature2)
    {
        Creature first = creatures[creature1];
        Creature second = creatures[creature2];
        hit(first, second); // the part to be completed by inheritors.
        // With strategy pattern this line will be gameStragety.hit();
        hit(second, first); // the part to be completed by inheritors
        // With strategy pattern this line will be gameStragety.hit();

        if (first.health > 0 && second.health > 0) return -1;//both alive
        if (first.health <= 0 && second.health <= 0) return -1;//both dead

        return (first.health > second.health)? creature1:creature2;

    }

    // attacker hits other creature
    protected abstract void hit(Creature attacker, Creature other);
}

class TemporaryCardDamageGame extends CardGame
{
    public TemporaryCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        int tempHealth=other.health - attacker.attack;
        if (tempHealth<=0) other.health=tempHealth;
    }
}

class PermanentCardDamageGame extends CardGame
{
    public PermanentCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        other.health-=attacker.attack;
    }
}