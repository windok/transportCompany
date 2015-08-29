package Person;

import Person.Skills.Skill;

public class Employee {

    private Skill skill;
    private int qualification;
    private int salary;
    private String region;

    public Employee(Skill skill, int qualification, int salary, String region) {
        setSkill(skill).setQualification(qualification).setSalary(salary).setRegion(region);
    }

    public void doJob() {
        getSkill().perform();
    }

    public Skill getSkill() {
        return skill;
    }

    public Employee setSkill(Skill skill) {
        this.skill = skill;
        return this;
    }

    public int getQualification() {
        return qualification;
    }

    public Employee setQualification(int qualification) {
        this.qualification = qualification;
        return this;
    }

    public int getSalary() {
        return salary;
    }

    public Employee setSalary(int salary) {
        this.salary = salary;
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
