package Person.Skills;

import java.util.HashMap;

public class NotAbleSkill extends BaseSkill {

    public NotAbleSkill() {
        super(QUALIFICATION_NO);
    }

    protected void initializeSalaryMap() {
        this.setMarketSalaryMapByQualification(new HashMap<Integer, Integer>() {{
            put(QUALIFICATION_NO, 0);
        }});
    }

    public void perform() throws UnsupportedOperationException {
        System.out.println("Employee can not drive any vehicle");
        throw new UnsupportedOperationException();
    }
}
