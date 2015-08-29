package Builders.Employee;

import Builders.EmployeeBuilder;
import Person.Qualification;
import Person.Skills.DriveAircraftSkill;
import Person.Skills.Skill;

public class PilotBuilder extends EmployeeBuilder {

    @Override
    protected Skill createSkill() {
        return new DriveAircraftSkill();
    }

    @Override
    protected int getSalary(Qualification qualification) {
        return qualification.getPilotSalary();
    }
}
