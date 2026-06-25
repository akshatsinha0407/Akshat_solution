package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        setupData();
        testGetAllPermanentEmployees();
        testGetAverageSalary();
        testGetAverageSalaryByDepartment();
        testGetAllEmployeesNative();
    }

    private static void setupData() {
        Department hr = new Department("HR");
        Department it = new Department("IT");
        departmentService.save(hr);
        departmentService.save(it);

        Skill java = new Skill("Java");
        skillService.save(java);

        Employee emp1 = new Employee("Alice Johnson", 70000, true, null);
        emp1.setDepartment(hr);
        Set<Skill> skills1 = new HashSet<>();
        skills1.add(java);
        emp1.setSkillList(skills1);
        employeeService.save(emp1);

        Employee emp2 = new Employee("Bob Brown", 60000, true, null);
        emp2.setDepartment(it);
        employeeService.save(emp2);

        Employee emp3 = new Employee("Charlie Davis", 55000, false, null);
        emp3.setDepartment(it);
        employeeService.save(emp3);
    }

    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start - HQL getAllPermanentEmployees()");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
        LOGGER.info("End");
    }

    private static void testGetAverageSalary() {
        LOGGER.info("Start - HQL getAverageSalary() (all employees)");
        double avg = employeeService.getAverageSalary();
        LOGGER.debug("Average Salary:{}", avg);
        LOGGER.info("End");
    }

    private static void testGetAverageSalaryByDepartment() {
        LOGGER.info("Start - HQL getAverageSalary(departmentId)");
        double avg = employeeService.getAverageSalary(2);
        LOGGER.debug("Average Salary for department 2 (IT):{}", avg);
        LOGGER.info("End");
    }

    private static void testGetAllEmployeesNative() {
        LOGGER.info("Start - Native Query getAllEmployeesNative()");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        LOGGER.debug("All Employees (Native Query):{}", employees);
        LOGGER.info("End");
    }
}
