package Person;

import Person.Skills.BaseSkill;

public class Employee {

    private BaseSkill skill;
    private String region;

    public Employee(BaseSkill skill) {
        this.setSkill(skill);
    }

    public void doJob()
    {
        this.getSkill().perform();
    }

    public BaseSkill getSkill() {
        return skill;
    }

    public Employee setSkill(BaseSkill skill) {
        this.skill = skill;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Employee setRegion(String region) {
        this.region = region;
        return this;
    }
}
