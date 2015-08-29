package Builders.Employee;

import Builders.EmployeeBuilder;
import Person.Skills.DriveAircraftSkill;
import Person.Skills.Skill;

import java.util.HashMap;

public class PilotBuilder extends EmployeeBuilder {

    @Override
    protected void initializeMarketSalaries() {
        this.setMarketSalaryMapByQualification(new HashMap<Integer, Integer>(){{
            put(QUALIFICATION_FIRST, 1500);
            put(QUALIFICATION_SECOND, 1750);
            put(QUALIFICATION_THIRD, 2100);
            put(QUALIFICATION_FOURTH, 2600);
            put(QUALIFICATION_FIFTH, 3400);
        }});
    }

    @Override
    protected Skill createSkill() {
        return new DriveAircraftSkill();
    }
}
