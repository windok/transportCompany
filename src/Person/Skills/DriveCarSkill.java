package Person.Skills;

import java.util.HashMap;
import java.util.Map;

public class DriveCarSkill extends BaseSkill{

    protected Map<Integer, Integer> marketSalaryMapByQualification = new HashMap<Integer, Integer>(){{
        put(QUALIFICATION_FIRST, 500);
        put(QUALIFICATION_SECOND, 550);
        put(QUALIFICATION_THIRD, 610);
        put(QUALIFICATION_FOURTH, 680);
        put(QUALIFICATION_FIFTH, 770);
    }};

    public DriveCarSkill(int qualification) {
        super(qualification);
    }

    public void perform() {
        System.out.println("Person is driving a car");
    }

}
