package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.FormattedEmploeey;
import ru.job4j.ood.srp.store.Store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class JSONReport implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final Gson gson;

    public JSONReport(Store store, DateTimeParser<Calendar> dateTimeParser, Gson gson) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.gson = gson;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<FormattedEmploeey> formattedEmployees = new ArrayList<>();
        for (Employee employee : store.findBy(filter)) {
            formattedEmployees.add(new FormattedEmploeey(employee.getName(),
                    dateTimeParser.parse(employee.getHired()),
                    dateTimeParser.parse(employee.getFired()), employee.getSalary()));
        }
        FormattedEmploeey[] employeesArray = new FormattedEmploeey[formattedEmployees.size()];
        formattedEmployees.toArray(employeesArray);
        return gson.toJson(employeesArray);
    }
}
