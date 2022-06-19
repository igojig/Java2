package lesson_1.participant;

import java.util.concurrent.ThreadLocalRandom;

public class Robot implements Participant{
    private final static int MAX_RUN_LENGTH=50;
    private final static int MAX_JUMP_LENGTH=5;

    protected static int count;

    private final String name;
    private final int id;
    private final int maxJumpLength;
    private final int maxRunLength;

    public Robot() {
        this.name="Робот " + (++count);
        this.id = count;
        this.maxJumpLength = ThreadLocalRandom.current().nextInt(1, MAX_JUMP_LENGTH + 1);
        this.maxRunLength = ThreadLocalRandom.current().nextInt(1, MAX_RUN_LENGTH + 1);
    }


    @Override
    public boolean jump(int length) {
        System.out.println(name + " собирается прыгать");
        if(length>maxJumpLength){
            System.out.println(name + " не прыгнул: " + length + " Могу только: " + maxJumpLength);
            return false;
        } else {
            System.out.println(name +" прыгнул: " + length);
            return true;
        }

    }

    @Override
    public boolean run(int length) {
        System.out.println(name + " собирается бежать");
        if(length>maxRunLength){
            System.out.println(name + " не пробежал: " + length + " Могу только: " + maxRunLength);
            return false;
        } else {
            System.out.println(name+" пробежал: " + length);
            return true;
        }
    }

    @Override
    public String toString() {
        return name +
                ", могу прыгать до " + maxJumpLength +
                ", могу бегать до " + maxRunLength;
    }
}
