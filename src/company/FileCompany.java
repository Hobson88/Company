package company;

import java.io.IOException;
import java.nio.charset.Charset;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Statement;
import java.util.*;
import java.util.function.Predicate;

public class FileCompany implements Company {


    @Override
    public List<Employee> findEmployeeByFirstName(String name) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("employees.txt"), Charset.forName("UTF-8"));

            List<Employee> employeeList = new ArrayList<>();

            for (String line : lines
            ) {
                //first index = name, second index = lastname
                String[] firstNameAndLastName = line.split(" ");
                if (firstNameAndLastName[0].equals(name)) {

                    employeeList.add(new Employee(firstNameAndLastName[0], firstNameAndLastName[1]));
                }
            }
            return employeeList;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read employee.txt, because ioexception is thrown", e);
        }
    }

    @Override
    public void add(Employee... entities) {
        List<Employee> employeeList = Arrays.asList(entities);
        List<String> employeeLines = new ArrayList<>();

        for (Employee e : employeeList) {
            employeeLines.add(e.toString());
        }
        // To możemy wykorzystać do zapisu kolekcji jednoelementowej
        // List<String> lines = Collections.singletonList("e.toString()");
        try {
            //
            Files.write(Paths.get("employees.txt"), employeeLines, Charset.forName("UTF-8"), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e1) {
            throw new RuntimeException("Failed to add employee, because ioexception is thrown", e1);
        }
    }

    @Override
    public Collection<Employee> findAll() {
        return null;
    }

    @Override
    public Collection<Employee> findByPredicate(Predicate<Employee> predicate) {
        return null;
    }
}
