package company;

import java.util.List;

public interface Company extends Repository<Employee> {
    public List<Employee> findEmployeeByFirstName(String name);
}
