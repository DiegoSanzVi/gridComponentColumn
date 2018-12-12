package org.vaadin.diego;

import java.util.Objects;

public class Person implements Cloneable {
    private int age;
    private String name;
    private Role role;

    public Person(String name, int age ) {
        this.age = age;
        this.name = name;
        this.role = Role.USER;
    }

    public Person(String name, int age, Role role ) {
        this.age = age;
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName());
    }

    public enum Role {
        ADMIN("administrator"), DEVELOPER("developer"), USER("user");

        private String text;

        Role(String text) {
            this.text = text;
        }
    }
}