package com.windok.Person.Skills;

public class NotAbleSkill implements Skill {

    public void perform() throws UnsupportedOperationException {
        System.out.println("Employee can not drive any vehicle");
        throw new UnsupportedOperationException();
    }
}
