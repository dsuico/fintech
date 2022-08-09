package com.peerlender.lendingengine.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = -7702063606321069459L;
    @Id
    private String username;
    @Column(nullable = true)
    private String firstName;
    @Column(nullable = true)
    private String lastName;
    @Column(nullable = true)
    private int age;
    @Column(nullable = true)
    private String occupation;

    @OneToOne(cascade = CascadeType.ALL)
    private Balance balance;

    public User() {}

    public User(String username, String firstName, String lastName, int age, String occupation, Balance balance) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.occupation = occupation;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void topUp(final Money money) {
        balance.topUp(money);
    }

    public void withdraw(final Money money) {
        balance.withdraw(money);
    }

    public Balance getBalance() {
        return balance;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        User user = (User) object;
        return age == user.age && java.util.Objects.equals(username, user.username) && java.util.Objects.equals(firstName, user.firstName) && java.util.Objects.equals(lastName, user.lastName) && java.util.Objects.equals(occupation, user.occupation);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), username, firstName, lastName, age, occupation);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
