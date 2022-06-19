package lesson_1;

import lesson_1.participant.Cat;
import lesson_1.participant.Human;
import lesson_1.participant.Participant;
import lesson_1.participant.Robot;
import lesson_1.stage.Barrier;
import lesson_1.stage.Track;
import lesson_1.stage.Wall;

public class Main {
    public static void main(String[] args) {

        Barrier[] barriers = {
                new Track(),
                new Track(),
                new Wall()
        };

        Participant[] participants = {
                new Cat(),
                new Human(),
                new Cat(),
                new Robot()
        };

        for (Participant participant : participants) {
            System.out.println(participant);
        }

        System.out.println();

        for (Barrier barrier : barriers) {
            System.out.println(barrier);
        }

        System.out.println();

        for (Participant participant : participants) {
            for (Barrier barrier : barriers) {
                if(!barrier.doAction(participant)){
                    System.out.println("сошел с дистанции");
                    System.out.println();
                    break;
                }
                System.out.println();
            }

        }
    }
}