package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.io.*;
import java.nio.file.Path;
import java.util.Calendar;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DeveloperReportEngineTest {
    @Test
    void whenGenerateDeveloperReportThenWriteReportToFile(@TempDir Path tempDir) throws IOException {
        File target = tempDir.resolve("target.txt").toFile();
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new DeveloperReportEngine(store, parser, target.getAbsolutePath());
        engine.generate(e -> true);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(parser.parse(worker.getHired())).append(";")
                .append(parser.parse(worker.getFired())).append(";")
                .append(worker.getSalary());

        StringBuilder result = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(result::append);
        }
        assertThat(result.toString()).isEqualTo(expected.toString());
    }
}