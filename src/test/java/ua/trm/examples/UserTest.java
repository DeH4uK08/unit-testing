package ua.trm.examples;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private List<User> testUsers;

    @BeforeEach
    void setUp() {
        testUsers = new ArrayList<>();

        testUsers.add(new User("Denys", 18, Sex.MALE));
        testUsers.add(new User("Liza", 17, Sex.FEMALE));
        testUsers.add(new User("Andrew", 18, Sex.MALE));
    }

    @Test
    void When_ThreeUsersAreCreated_Expect_ListOfThreeUsers() {
        List<User> expected = testUsers;

        List<User> actual = User.getAllUsers();

        Assert.assertEquals(expected, actual);
    }

    @Test
    void When_GetAllUsers_Expect_NotNullListOfThreeUsers() {
        List<User> actual = User.getAllUsers();

        Assert.assertNotNull(actual);
    }

    @Test
    void Should_ReturnListOfTwoMaleUsers_When_TwoMenAreCreated() {
        List<User> expected = testUsers
                .stream()
                .filter(user -> user.getSex() == Sex.MALE)
                .collect(Collectors.toList());

        List<User> actual = User.getAllUsersBySex(Sex.MALE);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void Should_ReturnNotNullListOfTwoMaleUsers_When_TwoMenAreCreated() {
        List<User> expected = User.getAllUsersBySex(Sex.MALE);

        Assert.assertNotNull(expected);
    }

    @Test
    void Should_ReturnListOfTwoFemaleUsers_When_UserSexIsFemale() {
        List<User> expected = testUsers
                .stream()
                .filter(user -> user.getSex() == Sex.FEMALE)
                .collect(Collectors.toList());

        List<User> actual = User.getAllUsersBySex(Sex.FEMALE);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void Should_ReturnNotNullListOfTwoFemaleUsers_When_UserSexIsFemale() {
        List<User> expected = User.getAllUsersBySex(Sex.FEMALE);

        Assert.assertNotNull(expected);
    }

    @Test
    void Given_ThreeUsersAreCreated_When_GetNumberOfUsers_Then_ReturnThree() {
        int expected = User.getNumberOfUsers();

        final int actual = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void Given_ThreeUsersAreCreated_When_UserSexIsMale_Then_ResultWillBeTwo() {
        int expected = User.getNumberOfUsersBySex(Sex.MALE);

        final int actual = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void Given_ThreeUsersAreCreated_When_UserSexIsFemale_Then_ReturnOne() {
        int expected = User.getNumberOfUsersBySex(Sex.FEMALE);

        final int actual = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void Given_ThreeUsersAreCreated_When_GetNumberOfYearsOfAllUsers_Then_ReturnFiftyThree() {
        int expected = User.getNumberOfYearsOfAllUsers();

        final int actual = 53;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void Given_ThreeUsersAreCreated_When_UserSexIsMale_Then_ReturnThirtySeven() {
        int expected = User.getNumberOfYearsOfAllUsersBySex(Sex.MALE);

        final int actual = 36;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void Given_ThreeUsersAreCreated_When_UserSexIsFemale_Then_ReturnThirtySeven() {
        int expected = User.getNumberOfYearsOfAllUsersBySex(Sex.FEMALE);

        final int actual = 17;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void Given_ThreeUsersAreCreated_When_GetAverageAgeOfAllUsers_Then_ResultWillBeEighteen() {
        int expected = User.getAverageAgeOfAllUsers();

        final int actual = 17;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void Given_ThreeUsersAreCreated_When_UserSexIsMale_Then_ReturnEighteen() {
        int expected = User.getAverageAgeOfAllUsersBySex(Sex.MALE);

        final int actual = 18;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void Given_ThreeUsersAreCreated_When_UserSexIsFemale_Then_ReturnSeventeen() {
        int expected = User.getAverageAgeOfAllUsersBySex(Sex.FEMALE);

        final int actual = 17;

        Assert.assertEquals(expected, actual);
    }

    @Test
    @Disabled("setUp method initializes users")
    void Given_NoUserIsCreated_When_GetAverageAgeOfAllUsers_Then_ThrowException() {
        assertThrows(NullPointerException.class, User::getAverageAgeOfAllUsers);
    }

    @Test
    void Given_ThreeUsersAreCreated_When_GetNameOfEachUser_Then_ReturnEqualResults() {
        List<User> users = User.getAllUsers();

        assertAll("user name",
                () -> assertEquals("Denys", users.get(0).getName()),
                () -> assertEquals("Liza", users.get(1).getName()),
                () -> assertEquals("Andrew", users.get(2).getName())
        );
    }

}