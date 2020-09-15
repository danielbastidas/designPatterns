import java.util.ArrayList;
import java.util.List;

/** Space optimizations.
 * A space optimization technique that let us use less memory by storing
 * externally the data associated with similar objects */
class Scratch {
    public static void main(String[] args) {
        Sentence sentence = new Sentence("alpha beta gamma [] ");
        sentence.getWord(4).capitalize = false;
        System.out.println(sentence);
    }
}

class Sentence
{
    private String plainText;
    List<WordToken> tokens = new ArrayList<>();

    public Sentence(String plainText)
    {
        this.plainText = plainText;
    }

    public WordToken getWord(int index)
    {
        WordToken token = new WordToken(index);
        tokens.add(token);
        return token;
    }

    @Override
    public String toString()
    {
        String[] words = plainText.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int index = 0;index < words.length;index++){

            for (WordToken token: tokens) {
                if (token.cover(index)) {
                    sb.append(
                            token.capitalize?
                                    words[index].toUpperCase(): words[index]
                    );
                } else sb.append(words[index]);
            }

            if ((index+1) < words.length) sb.append(" ");

        }

        return sb.toString();
    }

    class WordToken
    {
        public boolean capitalize;
        private int position;

        public WordToken(int position) {
            this.position = position;
        }

        public boolean cover(int position) {
            return this.position == position;
        }
    }

}