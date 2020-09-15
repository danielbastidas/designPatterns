import java.util.ArrayList;
import java.util.List;

/** Facilitates communication between components without them necessary be
 * aware of each other or having direct (reference) access to each other */
class Scratch {
    public static void main(String[] args) {
        
    }
}

class Participant
{
    private Mediator mediator;
    public int value=0;
    public Participant(Mediator mediator)
    {
        this.mediator = mediator;
        this.mediator.join(this);
    }

    public void say(int n)
    {
        mediator.broadCast(this,n);
    }

    public void receive(int value) {
        this.value+=value;
    }
}

class Mediator
{
    List<Participant> participants = new ArrayList<>();

    public void Mediator(){}

    public void join(Participant participant) {
        participants.add(participant);
    }

    public void broadCast(Participant sourceParticipant, int value) {
        for (Participant participant:participants) {
            if (!participant.equals(sourceParticipant)) {
                participant.receive(value);
            }

        }
    }


}