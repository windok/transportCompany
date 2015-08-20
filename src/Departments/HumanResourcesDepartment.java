package Departments;

import Person.Employee;
import Person.Skills.*;

import java.util.Random;

public class HumanResourcesDepartment {

    public static final String EMPLOYEE_TYPE_DRIVER = "driver";
    public static final String EMPLOYEE_TYPE_PILOT = "pilot";
    public static final String EMPLOYEE_TYPE_CAPTAIN = "captain";

    public Employee hire(String employeeType) {
        BaseSkill skill;

        Random random = new Random();
        int qualification = random.nextInt(BaseSkill.QUALIFICATION_FIFTH);

        switch (employeeType) {
            case EMPLOYEE_TYPE_DRIVER:
                skill = new DriveCarSkill(qualification);
                break;
            case EMPLOYEE_TYPE_PILOT:
                skill = new DriveAircraftSkill(qualification);
                break;
            case EMPLOYEE_TYPE_CAPTAIN:
                skill = new DriveBoatSkill(qualification);
                break;
            default:
                skill = new NotAbleSkill();
        }

        return new Employee(skill);
    }

}
