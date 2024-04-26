package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.model.FormattedEmploeey;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class XMLReport implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final JAXBContext context;

    public XMLReport(Store store, DateTimeParser<Calendar> dateTimeParser, JAXBContext context) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.context = context;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<FormattedEmploeey> formattedEmployees = new ArrayList<>();
        for (Employee employee : store.findBy(filter)) {
            formattedEmployees.add(new FormattedEmploeey(employee.getName(),
                    dateTimeParser.parse(employee.getHired()),
                    dateTimeParser.parse(employee.getFired()), employee.getSalary()));
        }
        Employees employees = new Employees(formattedEmployees);
        Marshaller marshaller;
        String result;
        try {
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(employees, writer);
            result = writer.getBuffer().toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
