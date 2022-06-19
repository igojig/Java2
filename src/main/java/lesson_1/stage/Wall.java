package lesson_1.stage;

import lesson_1.participant.Participant;

public class Wall extends Barrier{
    private static final int UPPER_LENGTH=5;

    private static int count;
    private final int id;

    public Wall() {
        super("Стена " + (++count), UPPER_LENGTH);
        id=count;
    }

    @Override
    public String toString() {
        return getName() + ", высота:" + getLength();
    }


    @Override
   public boolean doAction(Participant participant) {
        System.out.println(name);
       return participant.jump(length);

    }
}
