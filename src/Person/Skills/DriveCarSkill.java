package Person.Skills;

import java.util.HashMap;

public class DriveCarSkill extends BaseSkill {

    public DriveCarSkill(int qualification) {
        super(qualification);
    }

    protected void initializeSalaryMap() {
        this.setMarketSalaryMapByQualification(new HashMap<Integer, Integer>(){{
            put(QUALIFICATION_FIRST, 500);
            put(QUALIFICATION_SECOND, 550);
            put(QUALIFICATION_THIRD, 610);
            put(QUALIFICATION_FOURTH, 680);
            put(QUALIFICATION_FIFTH, 770);
        }});
    }

    public void perform() {
        System.out.println("Employee is driving a car");
    }

}
