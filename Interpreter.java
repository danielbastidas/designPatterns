import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/** A component that processes structured text data. Does so by turning it
 * into separate lexical tokens (lexing) and then interpreting sequences of
 * said tokens (parsing)
 * It is a behavioral pattern
 */
class Scratch {
    public static void main(String[] args) {
        ExpressionProcessor expressionProcessor = new ExpressionProcessor();
        expressionProcessor.variables.put('x', 5);
        System.out.println(expressionProcessor.calculate("10-2-x"));
    }
}

class ExpressionProcessor
{
    public Map<Character, Integer> variables = new HashMap<>();
    public List<Token> tokens = new ArrayList<>();

    public int calculate(String expression)
    {
        // todo test token extraction
        // todo: implement parser

        tokens = lexing(expression);
        return parsing(tokens).eval();
    }

    public List<Token> lexing(String input) {

        for (int index = 0; index < input.length(); index++) {
            switch(input.charAt(index)) {
                case '+':
                    tokens.add(new Token(Token.Type.PLUS,
                            String.valueOf(input.charAt(index))));
                    break;
                case '-':
                    tokens.add(new Token(Token.Type.MINUS,
                          String.valueOf(input.charAt(index))  ));
                    break;
                default:
                    if ( Character.isDigit(input.charAt(index)) ) {
                        int tokenLastPosition = getTokenLastPosition(input,
                                index, Character::isDigit);
                        String tokenText = input.substring(index,
                                tokenLastPosition) ;
                        index=tokenLastPosition-1;
                        tokens.add(new Token(Token.Type.NUMBER, tokenText));
                    } else {
                        int tokenLastPosition = getTokenLastPosition(input,
                                index, Character::isLetter);
                        String tokenText = input.substring(index,
                                tokenLastPosition);
                        index=tokenLastPosition-1;
                        tokens.add(new Token(Token.Type.VARIABLE, tokenText));
                    }
                    break;
            }

        }

        return tokens;
    }

    public Element parsing(List<Token> tokens) {

        BinaryOperatorElement rootElement = new BinaryOperatorElement();
        rootElement.type = BinaryOperatorElement.Type.NOTHING;
        boolean haveLHS = false;

        for (int index = 0; index < tokens.size(); index++) {
            Token token = tokens.get(index);
            switch (token.getType()) {
                case NUMBER:
                    NumberElement numberElement =
                            new NumberElement(token.getText());
                    if (!haveLHS) {
                        rootElement.leftElement = numberElement;
                        haveLHS = true;
                    } else rootElement.rightElement = numberElement;
                    break;
                case VARIABLE:
                    if (token.getText().length() <=1) {
                        Element variableElement = new VariableElement(token.getText(),
                                (variables.get( token.getText().charAt(0))));
                        if (!haveLHS) {
                            rootElement.leftElement = variableElement;
                            haveLHS = true;
                        } else rootElement.rightElement = variableElement;
                    } else {
                        rootElement.leftElement = new NumberElement("0");
                        rootElement.type = BinaryOperatorElement.Type.NOTHING;
                        return rootElement;
                    }
                    break;
                case PLUS:
                    rootElement.type = BinaryOperatorElement.Type.ADDITION;
                    break;
                case MINUS:
                    rootElement.type = BinaryOperatorElement.Type.SUBTRACTION;
                    break;
            }
        }

        return rootElement;
    }

    public int getTokenLastPosition(String input, int startPosition,
                                    Predicate<Character> predicate) {
        StringBuilder sb = new StringBuilder(""+input.charAt(startPosition));
        int j = startPosition+1;
        for (; j<input.length();j++) {
            if (predicate.test(input.charAt(j))) sb.append(input.charAt(j));
            else break;
        }
        return j;
    }
}

class Token {
    enum Type {
        NUMBER,
        VARIABLE,
        PLUS,
        MINUS
    }

    private Type type;
    private String text;

    public Token(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

class NumberElement implements Element {

    private String text;

    public NumberElement(String text) {
        this.text = text;
    }

    @Override
    public int eval() {
        return Integer.valueOf(text);
    }
}

class BinaryOperatorElement implements Element {

    public Element leftElement;
    public Element rightElement;
    public Type type;

    enum Type {
        ADDITION,
        SUBTRACTION,
        NOTHING

    }

    public BinaryOperatorElement(){}

    @Override
    public int eval() {
        int result = 0;
        switch (type) {
            case ADDITION:
                result = leftElement.eval() + rightElement.eval();
                break;
            case SUBTRACTION:
                result = leftElement.eval() - rightElement.eval();
                break;
            case NOTHING:
                result = leftElement.eval();
                break;
        }

        return result;
    }
}

class VariableElement implements Element {

    private String variable;
    private int value;

    public VariableElement(String variable, int value) {
        this.variable = variable;
        this.value = value;
    }

    @Override
    public int eval() {
        return (variable.length() > 1)? 0:value;
    }
}

interface Element {
    public int eval();
}