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
        testManyToOne();
        testOneToMany();
        testManyToMany();
        testAddSkillToEmployee();
    }

    private static void setupData() {
        Department hr = new Department("HR");
        Department it = new Department("IT");
        departmentService.save(hr);
        departmentService.save(it);

        Skill java = new Skill("Java");
        Skill sql = new Skill("SQL");
        skillService.save(java);
        skillService.save(sql);

        Employee emp1 = new Employee("Alice Johnson", 70000, true, null);
        emp1.setDepartment(hr);
        employeeService.save(emp1);

        Employee emp2 = new Employee("Bob Brown", 60000, true, null);
        emp2.setDepartment(it);
        employeeService.save(emp2);

        Employee emp3 = new Employee("Charlie Davis", 55000, false, null);
        emp3.setDepartment(it);
        employeeService.save(emp3);
    }

    private static void testManyToOne() {
        LOGGER.info("Start - ManyToOne (Employee -> Department)");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee:{}", employee);
        LOGGER.debug("Department:{}", employee.getDepartment());
        LOGGER.info("End");
    }

    private static void testOneToMany() {
        LOGGER.info("Start - OneToMany (Department -> Employees)");
        Department department = departmentService.get(2);
        LOGGER.debug("Department:{}", department);
        LOGGER.debug("Employees in department:{}", department.getEmployeeList());
        LOGGER.info("End");
    }

    private static void testManyToMany() {
        LOGGER.info("Start - ManyToMany (Employee <-> Skill)");
        Employee employee = employeeService.get(1);
        Set<Skill> skillList = new HashSet<>();
        skillList.add(skillService.get(1));
        skillList.add(skillService.get(2));
        employee.setSkillList(skillList);
        employeeService.save(employee);
        LOGGER.debug("Employee skills:{}", employee.getSkillList());
        LOGGER.info("End");
    }

    private static void testAddSkillToEmployee() {
        LOGGER.info("Start - Add additional skill to employee");
        Employee employee = employeeService.get(2);
        Skill skill = skillService.get(1);

        Set<Skill> skillList = employee.getSkillList();
        if (skillList == null) {
            skillList = new HashSet<>();
        }
        skillList.add(skill);
        employee.setSkillList(skillList);

        employeeService.save(employee);
        LOGGER.debug("Updated employee skills:{}", employee.getSkillList());
        LOGGER.info("End");
    }
}
