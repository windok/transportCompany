package Builders.Employee;

import Builders.EmployeeBuilder;
import Person.Qualification;
import Person.Skills.DriveBoatSkill;
import Person.Skills.Skill;

public class CaptainBuilder extends EmployeeBuilder {

    @Override
    protected Skill createSkill() {
        return new DriveBoatSkill();
    }

    @Override
    protected int getSalary(Qualification qualification) {
        return qualification.getCaptainSalary();
    }
}
