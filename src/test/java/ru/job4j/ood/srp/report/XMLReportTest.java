package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class XMLReportTest {
    @Test
    void whenUseXMLReportThenGetXMLString() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("eduardo", now, now, 10000);

        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(Employees.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        Report report = new XMLReport(store, parser, context);
        String actual = report.generate(e -> true);
        StringBuilder builder = new StringBuilder();
        String separator = System.lineSeparator();
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append(separator)
                .append("<employees>")
                .append(separator)
                .append("    <employee>")
                .append(separator)
                .append("        <name>eduardo</name>")
                .append(separator)
                .append(String.format("        <hired>%s</hired>", parser.parse(now)))
                .append(separator)
                .append(String.format("        <fired>%s</fired>", parser.parse(now)))
                .append(separator)
                .append("        <salary>10000.0</salary>")
                .append(separator)
                .append("    </employee>")
                .append(separator)
                .append("</employees>")
                .append(separator);
        String expected = builder.toString();
        assertThat(actual).isEqualTo(expected);
    }
}