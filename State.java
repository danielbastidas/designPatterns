import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** The objects behavior is determined by its state.
 * An objects transitions from one state to another (something needs to
 * trigger a transition).
 * A formalized construct  which manages state and transitions is called a
 * state machine.
 * Applies when there are state transitions with sufficient complexity
 * state -> transition/trigger/events -> state */
class Scratch {
    public static void main(String[] args) {
        CombinationLock combinationLock = new CombinationLock(new int[]{1,2,3
                ,4});

        assert combinationLock.status == "LOCKED";

        combinationLock.enterDigit(1);
        assert combinationLock.status.equals("1");

        combinationLock.enterDigit(2);
        assert combinationLock.status.equals( "12");

        combinationLock.enterDigit(3);
        assert combinationLock.status.equals( "123");

        combinationLock.enterDigit(5);
        assert combinationLock.status.equals("OPEN");


    }
}

class CombinationLock
{
    private int [] combination;
    public String status;

    enum State {
        LOCKED,
        IN_PROCESS,
        OPEN,
        ERROR
    }

    enum Event {
        ENTERING
    }

    Map<State, List<AbstractMap.SimpleEntry<Event, State>>> transitions =
            configureTransitions();

    static Map<State, List<AbstractMap.SimpleEntry<Event, State>>> configureTransitions() {
        Map<State, List<AbstractMap.SimpleEntry<Event, State>>> configuration = new HashMap<>();

        configuration.put(State.LOCKED,
                Stream.of(new AbstractMap.SimpleEntry<Event, State>(Event.ENTERING,
                        State.IN_PROCESS)).collect(Collectors.toList())
                 );

        configuration.put(State.IN_PROCESS,
                Stream.of(
                        new AbstractMap.SimpleEntry<Event, State>(Event.ENTERING,
                                State.IN_PROCESS)
                        ,
                        new AbstractMap.SimpleEntry<Event, State>(Event.ENTERING,
                        State.OPEN)
                        ,
                        new AbstractMap.SimpleEntry<Event, State>(Event.ENTERING,
                                State.ERROR) ).collect(Collectors.toList())
        );

        return  configuration;
    }

    private String combinationStr;


    public CombinationLock(int[] combination)
    {
        this.combination = combination;
        this.status="LOCKED";
        combinationStr=arrToStr(combination);
    }

    public void enterDigit(int digit)
    {
        if (status.equals("LOCKED")) status="";
        status+=""+digit;
        if (status.equals(combinationStr )) status="OPEN";
        else if (status.length()>=combination.length) status="ERROR";

    }

    private String arrToStr(int[] combination) {
        return  IntStream.of(combination).mapToObj(value -> String.valueOf(value)).
                collect(Collectors.joining("")).toString();
    }
}