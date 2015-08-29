package Builders.Employee;

import Builders.EmployeeBuilder;
import Person.Skills.DriveBoatSkill;
import Person.Skills.Skill;

import java.util.HashMap;

public class CaptainBuilder extends EmployeeBuilder {

    @Override
    protected void initializeMarketSalaries() {
        this.setMarketSalaryMapByQualification(new HashMap<Integer, Integer>(){{
            put(QUALIFICATION_FIRST, 1200);
            put(QUALIFICATION_SECOND, 1550);
            put(QUALIFICATION_THIRD, 2000);
            put(QUALIFICATION_FOURTH, 2550);
            put(QUALIFICATION_FIFTH, 3500);
        }});
    }

    @Override
    protected Skill createSkill() {
        return new DriveBoatSkill();
    }
}
