package Person.Skills;

import java.util.HashMap;
import java.util.Map;

public class NotAbleSkill extends BaseSkill {

    protected Map<Integer, Integer> marketSalaryMapByQualification = new HashMap<Integer, Integer>(){{
        put(QUALIFICATION_NO, 0);
    }};

    public NotAbleSkill(int qualification) {
        super(qualification);
    }

    public void perform() {
        System.out.println("Person can not drive any vehicle");
    }
}
