package Person.Skills;

import java.util.HashMap;
import java.util.Map;

public class DriveAircraftSkill extends BaseSkill {

    protected Map<Integer, Integer> marketSalaryMapByQualification = new HashMap<Integer, Integer>(){{
        put(QUALIFICATION_FIRST, 1500);
        put(QUALIFICATION_SECOND, 1750);
        put(QUALIFICATION_THIRD, 2100);
        put(QUALIFICATION_FOURTH, 2600);
        put(QUALIFICATION_FIFTH, 3400);
    }};

    public DriveAircraftSkill(int qualification) {
        super(qualification);
    }

    public void perform() {
        System.out.println("Person is driving an aircraft");
    }

}
