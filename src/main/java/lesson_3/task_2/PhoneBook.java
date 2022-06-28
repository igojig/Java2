package lesson_3.task_2;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneBook {

    Map<String, List<String>> storage = new HashMap<>();

    public PhoneBook() {
    }

    public void add(String name, String phoneNumber) {
//        List<String> listPhones = storage.getOrDefault(name, new ArrayList<>());
        List<String> listPhones = storage.computeIfAbsent(name, s -> new ArrayList<>());
        listPhones.add(phoneNumber);
        storage.putIfAbsent(name, listPhones);
    }

    public Optional<List<String>> getPhonesByName(String name) {
        return Optional.ofNullable(storage.get(name));
    }

    void printPhonesByName(String name) {
        System.out.println("Name: " + name);
        System.out.println("Phone(s):");
        getPhonesByName(name)
//                .ifPresentOrElse(s->System.out.printf("%s\n", s), () -> System.out.println("Not found"))
                .or(() -> Optional.of(List.of("Not found")))
                .stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "storage=" + storage +
                '}';
    }
}
