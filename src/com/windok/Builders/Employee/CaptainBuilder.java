package com.windok.Builders.Employee;

import com.windok.Builders.EmployeeBuilder;
import com.windok.Person.Qualification;
import com.windok.Person.Skills.DriveBoatSkill;
import com.windok.Person.Skills.Skill;

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
