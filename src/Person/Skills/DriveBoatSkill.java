package Person.Skills;

import java.util.HashMap;
import java.util.Map;

public class DriveBoatSkill extends BaseSkill {

    protected Map<Integer, Integer> marketSalaryMapByQualification = new HashMap<Integer, Integer>(){{
        put(QUALIFICATION_FIRST, 1200);
        put(QUALIFICATION_SECOND, 1550);
        put(QUALIFICATION_THIRD, 2000);
        put(QUALIFICATION_FOURTH, 2550);
        put(QUALIFICATION_FIFTH, 3500);
    }};

    public DriveBoatSkill(int qualification) {
        super(qualification);
    }

    public void perform() {
        System.out.println("Person is driving a boat");
    }

}
