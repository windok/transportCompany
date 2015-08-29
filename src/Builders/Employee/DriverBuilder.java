package Builders.Employee;

import Builders.EmployeeBuilder;
import Person.Qualification;
import Person.Skills.DriveCarSkill;
import Person.Skills.Skill;

public class DriverBuilder extends EmployeeBuilder {

    @Override
    protected Skill createSkill() {
        return new DriveCarSkill();
    }

    @Override
    protected int getSalary(Qualification qualification) {
        return qualification.getDriverSalary();
    }
}
