package ru.job4j.grabber.utuls;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


import java.time.LocalDate;
import java.time.LocalDateTime;

class HabrCareerDateTimeParserTest {
    @Test
    public void whenGetStringThenGetCorrectLocalDateTime() {
        DateTimeParser parser = new HabrCareerDateTimeParser();
        LocalDateTime expected = LocalDate.of(2024, 3, 6).atTime(21, 29, 22);
        LocalDateTime actual = parser.parse("2024-03-06T21:29:22+01:00");
        assertThat(actual).isEqualTo(expected);
    }

}