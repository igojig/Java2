package lesson_1.stage;

import lesson_1.participant.Participant;

public class Track extends Barrier {
    private static final int UPPER_LENGTH = 50;

    private static int count;
    private final int id;

    public Track() {
        super("Дорожка " + (++count), UPPER_LENGTH);
        id = count;
    }

    @Override
    public String toString() {
        return name + ", длина:" + getLength();
    }


    @Override
    public boolean doAction(Participant participant) {
        System.out.println(name);
        return participant.run(length);
    }


}
