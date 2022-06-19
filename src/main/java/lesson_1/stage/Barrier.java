package lesson_1.stage;

import lesson_1.participant.Participant;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Barrier {

    protected final String name;
    protected final int length;

    protected Barrier(String name, int upperLength) {
        this.name = name;
        this.length = calcLength(upperLength);
    }

    public String getName(){
        return name;
    }

    public int getLength(){
        return length;
    }

    private int calcLength(int upperLength){
        return ThreadLocalRandom.current().nextInt(1, upperLength+1);
    }

    public abstract boolean doAction(Participant participant);


}
