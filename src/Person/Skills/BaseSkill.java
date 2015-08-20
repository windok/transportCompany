package Person.Skills;

import java.util.Map;

public abstract class BaseSkill implements Skill {

    public static final Integer QUALIFICATION_NO = 0;
    public static final Integer QUALIFICATION_FIRST = 1;
    public static final Integer QUALIFICATION_SECOND = 2;
    public static final Integer QUALIFICATION_THIRD = 3;
    public static final Integer QUALIFICATION_FOURTH = 4;
    public static final Integer QUALIFICATION_FIFTH = 5;

    private int qualification;
    private int salary;
    private Map<Integer, Integer> marketSalaryMapByQualification;

    protected abstract void initializeSalaryMap();

    public BaseSkill(int qualification) {
        this.
                initializeSalaryMap();
                setQualification(qualification).
                setSalary(this.getMarketSalaryMapByQualification().get(qualification))
        ;
    }

    public Map<Integer, Integer> getMarketSalaryMapByQualification() {
        return marketSalaryMapByQualification;
    }

    public void setMarketSalaryMapByQualification(Map<Integer, Integer> marketSalaryMapByQualification) {
        this.marketSalaryMapByQualification = marketSalaryMapByQualification;
    }

    public int getQualification() {
        return qualification;
    }

    public BaseSkill setQualification(int qualification) {
        this.qualification = qualification;
        return this;
    }

    public int getSalary() {
        return salary;
    }

    public BaseSkill setSalary(int salary) {
        this.salary = salary;
        return this;
    }
}
