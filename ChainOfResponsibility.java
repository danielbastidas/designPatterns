import java.util.ArrayList;
import java.util.List;

/** Sequence of handlers processing an event one after another.
 * A chain of components who all get a chance to process a command or query,
 * optionally having a default processing implementation and an ability to
 * terminate the processing chain
 * It is a behavioral pattern
 * For instance the validation of a station tally received through an https
 * channel: the first component validates the digital signature of the data
 * to ensure the data was not modifier. The next component in the chain
 * decrypts and validate whether the data was transmitted from a device
 * recognized by the application and the last component in the chain validate
 * whether the data contains valid information, for example contest code
 */
class Scratch {
    public static void main(String[] args) {
        
    }
}

abstract class Creature
{
    public abstract int getAttack();
    public abstract int getDefense();
    public abstract void query(Object source, Query query);
}

class Goblin extends Creature
{
    private Game game;
    private int baseAttack = 1;
    private int baseDefense = 1;
    public Goblin(Game game)
    {
        this.game= game;
    }

    @Override
    public int getAttack()
    {
        Query query = new Query(Statistic.ATTACK);
        for (Creature creature:game.creatures) {
            creature.query(this, query);
        }
        return query.result;
    }

    @Override
    public int getDefense()
    {
        Query query = new Query(Statistic.DEFENSE);
        for (Creature creature:game.creatures) {
            creature.query(this, query);
        }
        return query.result;

    }

    public void query(Object source, Query query) {

        if (source == this) {
            switch(query.statistic) {
                case DEFENSE:query.result+=baseDefense;
                    break;
                case ATTACK:query.result+=baseAttack;
                    break;
            }
        } else if (query.statistic == Statistic.DEFENSE) {
            query.result++;
        }

    }

}

class GoblinKing extends Goblin
{
    private Game game;
    private int baseAttack = 3;
    private int baseDefense = 3;
    public GoblinKing(Game game)
    {
        super(game);
    }

    public void query(Object source, Query query) {

        if (source != this && query.statistic == Statistic.ATTACK) query.result++;
        else super.query(source, query);
    }
}

enum Statistic
{
    ATTACK, DEFENSE
}

class Game
{
    public List<Creature> creatures = new ArrayList<>();
}

class Query {
    public Statistic statistic;
    public int result;

    public Query(Statistic statistic) {
        this.statistic = statistic;
    }
}