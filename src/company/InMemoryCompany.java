package company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InMemoryCompany implements Company {
    List<Employee> employees = new ArrayList<>();

    @Override
    public void add(Employee... employee) {
        this.employees.addAll(Arrays.asList(employee));
    }

    @Override
    public Collection<Employee> findAll() {
        return employees;
    }

    @Override
    public Collection<Employee> findByPredicate(Predicate<Employee> predicate) {
        return findAll().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<Employee> findEmployeeByFirstName(String name) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee e : employees
        ) {
            if (e.getName().equals(name)) {
                foundEmployees.add(e);
            }
        }
        return foundEmployees;
    }
}
