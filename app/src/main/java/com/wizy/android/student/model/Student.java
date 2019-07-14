package com.wizy.android.student.model;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private String number;
    private String password;
    private Gender gender;
    private Standard standard;
    private List<Subject> favSubjects;
    private List<Subject> leastFavSubjects;
    private List<Hobby> hobbies;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public List<Subject> getLeastFavSubjects() {
        return leastFavSubjects;
    }

    public void setLeastFavSubjects(List<Subject> leastFavSubjects) {
        this.leastFavSubjects = leastFavSubjects;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Subject> getFavSubjects() {
        return favSubjects;
    }

    public void setFavSubjects(List<Subject> favSubjects) {
        this.favSubjects = favSubjects;
    }

    public enum Gender {
        BOY, GIRL
    }

    public enum Standard {
        FIVE("class 5."), SIX("class 6."), SEVEN("class 7."), EIGHT("class 8."), NINE("class 9."), TEN("class 10."), ELEVEN("class 11."), TWELVE("class 12.");

        String notation;
        Standard(String s) {
            notation = s;
        }

        @NotNull
        @Override
        public String toString() {
            return notation;
        }

        public static Standard fromString(String value) {
            for (Standard std : values()) {
                if (std.notation.equals(value)) {
                    return std;
                }
            }
            return null;
        }
    }

    public enum Subject {
        SCIENCE("science."), ENGLISH("english."), MATHS("maths."), SOCIAL_STUDIES("social studies."), LANGUAGES("languages."), COMPUTER_SCIENCE("computer science."),
        BIOLOGY("biology."), PHYSICS("physics."), CHEMISTRY("chemistry."), ACCOUNTANCY("accountancy."), ECONOMICS("economics."), BUSINESS_STUDIES("business studies.");

        String notation;
        Subject(String s) {
            notation = s;
        }

        @NotNull
        @Override
        public String toString() {
            return notation;
        }

        public static Subject fromString(String value) {
            for (Subject sbj : values()) {
                if (sbj.notation.equals(value)) {
                    return sbj;
                }
            }
            return null;
        }
    }

    public enum Hobby {
        GUITAR("guitar."), PAINTING("painting."), MARTIAL_ARTS("martial arts."), DRUM_AND_PERCUSSION("drums and percussion."), KEYBOARD("keyboard."), DANCE("dance.");

        String notation;
        Hobby(String s) {
            notation = s;
        }

        @Override
        public String toString() {
            return notation;
        }

        public static Hobby fromString(String value) {
            for (Hobby hb : values()) {
                if (hb.notation.equals(value)) {
                    return hb;
                }
            }
            return null;
        }
    }
}
