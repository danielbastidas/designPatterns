import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Memento design pattern.
 * Keeps snapshots of the changes in the system.
 * Allows rollback states
 * Can be used to implement undo/redo */
class Scratch {
    public static void main(String[] args) {
        
    }
}

class Token
{
    public int value = 0;

    public Token(int value)
    {
        this.value = value;
    }
}

class Memento
{
    public List<Token> tokens = new ArrayList<>();
}

class TokenMachine
{
    public List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value)
    {
        tokens.add(new Token(value));
        Memento memento = new Memento();
        memento.tokens = clone(tokens);
        return memento;
    }

    public Memento addToken(Token token)
    {
        tokens.add(new Token(token.value));
        Memento memento = new Memento();
        memento.tokens = clone(tokens);
        return memento;
    }

    public void revert(Memento m)
    {
        this.tokens = clone(m.tokens);
    }

    private List<Token> clone(List<Token> tokens) {
      return tokens.stream().map(token -> new Token(token.value)).collect(Collectors.toCollection(ArrayList::new));
    }
}