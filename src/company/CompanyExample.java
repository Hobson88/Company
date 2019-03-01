package company;

import java.util.function.Predicate;

public class CompanyExample {
    public static void main(String[] args) {
        Company company = chooseCompanyImplementation();
        Employee ferdek = new Employee("Ferdek","Kowalski");
        company.add(ferdek,
                    new Employee("Zdzisław", "Nowak"),
                    new Employee("Stanisław", "Kowalski"),
                    new Employee("Franciszek", "Wiśniewski"),
                    new Employee("Wiesława", "Mandaryna"),
                    new Employee("Henryk", "Sienkiewicz"),
                    new Employee("Stanisław", "Sienkiewicz"),
                    new Employee("Barbara", "Sienkiewicz"),
                    new Employee("Barbara", "Piercibąk"),
                    new Employee("Stanisław", "Piercibąk"));


        company.add(new Employee("Magda","Piercibąk"));

        System.out.println(company.findEmployeeByFirstName("Stanisław"));

      ;

//        Predicate<Employee> lastNamePredicate = e -> "Piercibąk".equals(e.getLastName());
//        Predicate<Employee> firstNamePredicate = e -> "Barbara".equals(e.getName());

//        System.out.println(company.findByPredicate(lastNamePredicate.or(firstNamePredicate)));


    }

    private static Company chooseCompanyImplementation() {
        // return new InMemoryCompany();
          return new FileCompany();
    }
}
