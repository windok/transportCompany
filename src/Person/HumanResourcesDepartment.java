package Person;

import Person.Skills.*;

import java.util.HashMap;
import java.util.Random;

public class HumanResourcesDepartment {

    public static final String EMPLOYEE_TYPE_DRIVER = "driver";
    public static final String EMPLOYEE_TYPE_PILOT = "pilot";
    public static final String EMPLOYEE_TYPE_CAPTAIN = "captain";

    private static final Integer QUALIFICATION_FIRST = 1;
    private static final Integer QUALIFICATION_SECOND = 2;
    private static final Integer QUALIFICATION_THIRD = 3;
    private static final Integer QUALIFICATION_FOURTH = 4;
    private static final Integer QUALIFICATION_FIFTH = 5;


    private HashMap <Integer, Integer> driversQualificationSalaryMap = new HashMap<Integer, Integer>(){{
        put(QUALIFICATION_FIRST, 500);
        put(QUALIFICATION_SECOND, 550);
        put(QUALIFICATION_THIRD, 610);
        put(QUALIFICATION_FOURTH, 680);
        put(QUALIFICATION_FIFTH, 770);
    }};

    private HashMap <Integer, Integer> pilotsQualificationSalaryMap = new HashMap<Integer, Integer>(){{
        put(QUALIFICATION_FIRST, 1500);
        put(QUALIFICATION_SECOND, 1750);
        put(QUALIFICATION_THIRD, 2100);
        put(QUALIFICATION_FOURTH, 2600);
        put(QUALIFICATION_FIFTH, 3400);
    }};

    private HashMap <Integer, Integer> captainsQualificationSalaryMap = new HashMap<Integer, Integer>(){{
        put(QUALIFICATION_FIRST, 1200);
        put(QUALIFICATION_SECOND, 1550);
        put(QUALIFICATION_THIRD, 2000);
        put(QUALIFICATION_FOURTH, 2550);
        put(QUALIFICATION_FIFTH, 3500);
    }};

    public Employee hire(String employeeType) {
        Random random = new Random();
        int qualification = random.nextInt(QUALIFICATION_FIFTH);

        switch (employeeType) {
            case EMPLOYEE_TYPE_DRIVER : return new Employee(new DriveCarSkill(), qualification, driversQualificationSalaryMap.get(qualification));
            case EMPLOYEE_TYPE_PILOT : return new Employee(new DriveAircraftSkill(), qualification, pilotsQualificationSalaryMap.get(qualification));
            case EMPLOYEE_TYPE_CAPTAIN : return  new Employee(new DriveBoatSkill(), qualification, captainsQualificationSalaryMap.get(qualification));
        }

        return new Employee(new NotAbleSkill(), 0, 0);
    }
}
