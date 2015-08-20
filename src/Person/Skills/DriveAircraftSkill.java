package Person.Skills;

import java.util.HashMap;

public class DriveAircraftSkill extends BaseSkill {

    public DriveAircraftSkill(int qualification) {
        super(qualification);
    }

    protected void initializeSalaryMap() {
        this.setMarketSalaryMapByQualification(new HashMap<Integer, Integer>(){{
            put(QUALIFICATION_FIRST, 1500);
            put(QUALIFICATION_SECOND, 1750);
            put(QUALIFICATION_THIRD, 2100);
            put(QUALIFICATION_FOURTH, 2600);
            put(QUALIFICATION_FIFTH, 3400);
        }});
    }

    public void perform() {
        System.out.println("Employee is driving an aircraft");
    }

}
