package Builders;

import Person.Employee;
import Person.Skills.Skill;

import java.util.Map;
import java.util.Random;

abstract public class EmployeeBuilder {

    public static final Integer QUALIFICATION_FIRST = 1;
    public static final Integer QUALIFICATION_SECOND = 2;
    public static final Integer QUALIFICATION_THIRD = 3;
    public static final Integer QUALIFICATION_FOURTH = 4;
    public static final Integer QUALIFICATION_FIFTH = 5;

    private Map<Integer, Integer> marketSalaryMapByQualification;

    private Random rand = new Random();

    public EmployeeBuilder() {
        initializeMarketSalaries();
    }

    abstract protected void initializeMarketSalaries();
    abstract protected Skill createSkill();

    public Employee hire(String region)
    {
        int qualification = rand.nextInt(QUALIFICATION_FIFTH) + 1;
        return new Employee(createSkill(), qualification, getMarketSalaryMapByQualification().get(qualification), region);
    }

    protected Map<Integer, Integer> getMarketSalaryMapByQualification() {
        return marketSalaryMapByQualification;
    }

    protected EmployeeBuilder setMarketSalaryMapByQualification(Map<Integer, Integer> marketSalaryMapByQualification) {
        this.marketSalaryMapByQualification = marketSalaryMapByQualification;
        return this;
    }
}
