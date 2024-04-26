package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class JSONReportTest {
    @Test
    void whenUseJSONReportThenGetJSONString() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("eduardo", now, now, 10000);

        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Report report = new JSONReport(store, parser, gson);
        String actual = report.generate(e -> true);
        StringBuilder builder = new StringBuilder();
        String separator = System.lineSeparator();
        builder.append("[")
                .append(separator)
                .append("  {")
                .append(separator)
                .append("    \"name\": \"eduardo\",")
                .append(separator)
                .append(String.format("    \"hired\": \"%s\",", parser.parse(now)))
                .append(separator)
                .append(String.format("    \"fired\": \"%s\",", parser.parse(now)))
                .append(separator)
                .append("    \"salary\": 10000.0")
                .append(separator)
                .append("  }")
                .append(separator)
                .append("]");
        String expected = builder.toString();
        assertThat(actual).isEqualTo(expected);
    }
}