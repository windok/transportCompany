package Person.Skills;

import java.util.HashMap;

public class DriveBoatSkill extends BaseSkill {

    public DriveBoatSkill(int qualification) {
        super(qualification);
    }

    protected void initializeSalaryMap() {
        this.setMarketSalaryMapByQualification(new HashMap<Integer, Integer>(){{
            put(QUALIFICATION_FIRST, 1200);
            put(QUALIFICATION_SECOND, 1550);
            put(QUALIFICATION_THIRD, 2000);
            put(QUALIFICATION_FOURTH, 2550);
            put(QUALIFICATION_FIFTH, 3500);
        }});
    }

    public void perform() {
        System.out.println("Employee is driving a boat");
    }

}
