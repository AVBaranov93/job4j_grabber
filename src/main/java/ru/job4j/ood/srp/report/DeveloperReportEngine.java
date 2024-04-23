package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.function.Predicate;

public class DeveloperReportEngine implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final String path;

    public DeveloperReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser, String path) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.path = path;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(dateTimeParser.parse(employee.getHired())).append(";")
                    .append(dateTimeParser.parse(employee.getFired())).append(";")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        try (PrintWriter out = new PrintWriter(path)) {
            out.println(text);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
