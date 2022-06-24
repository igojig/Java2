package lesson_3.task_2;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook=new PhoneBook();

        phoneBook.add("Ivanov", "IVANOV-11-12-13");
        phoneBook.add("Petrov", "PETROV-666-777-888");
        phoneBook.add("Ivanov", "IVANOV-222-333-444");
        phoneBook.add("Ivanov", "IVANOV-222-333-444");
        phoneBook.add("Sidorov", "SIDOROV-1-1-1-1");
        phoneBook.add("Sidorov", "SIDOROV-2-2-2-2");
        phoneBook.add("Ivanov", "IVANOV-11111111-222-333-444");

        System.out.println(phoneBook);
        System.out.println();

        phoneBook.printPhonesByName("Ivanov");
        System.out.println();
        phoneBook.printPhonesByName("Petrov");
        System.out.println();
        phoneBook.printPhonesByName("Sidorov");
        System.out.println();

        phoneBook.printPhonesByName("Unknown Name");
        System.out.println();
    }
}
