package Builders;

import Person.Employee;
import Person.Qualification;
import Person.Skills.Skill;
import Region.Region;

abstract public class EmployeeBuilder {

    abstract protected Skill createSkill();
    abstract protected int getSalary(Qualification qualification);

    public final Employee hire(Region region)
    {
        Qualification qualification = Qualification.random();
        return new Employee(createSkill(), qualification, getSalary(qualification), region);
    }

}
