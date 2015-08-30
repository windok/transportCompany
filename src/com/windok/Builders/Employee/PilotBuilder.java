package com.windok.Builders.Employee;

import com.windok.Builders.EmployeeBuilder;
import com.windok.Person.Qualification;
import com.windok.Person.Skills.DriveAircraftSkill;
import com.windok.Person.Skills.Skill;

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
