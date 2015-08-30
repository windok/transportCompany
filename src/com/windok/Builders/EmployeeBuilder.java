package com.windok.Builders;

import com.windok.Person.Employee;
import com.windok.Person.Qualification;
import com.windok.Person.Skills.Skill;
import com.windok.Region;

abstract public class EmployeeBuilder {

    abstract protected Skill createSkill();
    abstract protected int getSalary(Qualification qualification);

    public final Employee hire(Region region)
    {
        Qualification qualification = Qualification.random();
        return new Employee(createSkill(), qualification, getSalary(qualification), region);
    }

}
