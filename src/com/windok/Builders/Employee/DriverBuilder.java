package com.windok.Builders.Employee;

import com.windok.Builders.EmployeeBuilder;
import com.windok.Person.Qualification;
import com.windok.Person.Skills.DriveCarSkill;
import com.windok.Person.Skills.Skill;

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
