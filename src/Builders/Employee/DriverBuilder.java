package Builders.Employee;

import Builders.EmployeeBuilder;
import Person.Skills.DriveCarSkill;
import Person.Skills.Skill;

import java.util.HashMap;

public class DriverBuilder extends EmployeeBuilder {

    @Override
    protected void initializeMarketSalaries() {
        this.setMarketSalaryMapByQualification(new HashMap<Integer, Integer>(){{
            put(QUALIFICATION_FIRST, 500);
            put(QUALIFICATION_SECOND, 550);
            put(QUALIFICATION_THIRD, 610);
            put(QUALIFICATION_FOURTH, 680);
            put(QUALIFICATION_FIFTH, 770);
        }});
    }

    @Override
    protected Skill createSkill() {
        return new DriveCarSkill();
    }
}
