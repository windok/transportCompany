package com.windok.Person;

import com.windok.Person.Skills.Skill;
import com.windok.Region;

public class Employee {

    private Skill skill;
    private Qualification qualification;
    private int salary;
    private Region region;

    public Employee(Skill skill, Qualification qualification, int salary, Region region) {
        setSkill(skill).setQualification(qualification).setSalary(salary).setRegion(region);
    }

    public void doJob() {
        getSkill().perform();
    }

    public Skill getSkill() {
        return skill;
    }

    public Employee setSkill(Skill skill) {
        this.skill = skill;
        return this;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public Employee setQualification(Qualification qualification) {
        this.qualification = qualification;
        return this;
    }

    public int getSalary() {
        return salary;
    }

    public Employee setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public Employee setRegion(Region region) {
        this.region = region;
        return this;
    }
}
