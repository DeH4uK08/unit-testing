package ua.trm.examples;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
class User {

    private static Map<Long, User> allUsers;

    private static Long countId = 0L;

    private Long id;
    private String name;
    private int age;
    private Sex sex;

    User(String name, int age, Sex sex) {
        if (allUsers == null) {
            allUsers = new HashMap<>();
        }

        this.name = name;
        this.age = age;
        this.sex = sex;

        if (!allUsers.containsValue(this)) {
            countId++;
            this.id = countId;
            allUsers.put(this.id, this);
        }
    }

    static List<User> getAllUsers() {
        return new ArrayList<>(allUsers.values());
    }

    static List<User> getAllUsersBySex(Sex sex) {
        return getAllUsers()
                .stream()
                .filter(user -> user.sex == sex)
                .collect(Collectors.toList());
    }

    static int getNumberOfUsers() {
        return getAllUsers().size();
    }

    static int getNumberOfUsersBySex(Sex sex) {
        return getAllUsersBySex(sex).size();
    }

    static int getNumberOfYearsOfAllUsers() {
        return getAllUsers()
                .stream()
                .mapToInt(user -> user.age)
                .sum();
    }

    static int getNumberOfYearsOfAllUsersBySex(Sex sex) {
        return getAllUsers()
                .stream()
                .filter(user -> user.sex == sex)
                .mapToInt(User::getAge)
                .sum();
    }

    static int getAverageAgeOfAllUsers() {
        return getNumberOfYearsOfAllUsers() / getNumberOfUsers();
    }

    static int getAverageAgeOfAllUsersBySex(Sex sex) {
        return getNumberOfYearsOfAllUsersBySex(sex) / getNumberOfUsersBySex(sex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

}
