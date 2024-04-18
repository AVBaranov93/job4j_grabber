package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class GeneratorTest {
@Test
    public void whenPassTemplateThenGetString() {
    Generator generator = new PhraseGenerator();
    String template = "I am ${name}, Who are ${subject}? ";
    Map<String, String> phrases = new HashMap<>();
    phrases.put("name", "Eduardo");
    assertThat(generator.produce(template, phrases)).isEqualTo("I am Eduardo, Who are you? ");
}

@Test
    public void whenHaveRedundantKeyInTemplateThenGetException() {
    Generator generator = new PhraseGenerator();
    String template = "I am ${name}, i'm from ${city}. Who are ${subject}? ";
    Map<String, String> phrases = new HashMap<>();
    phrases.put("name", "Eduardo");
    assertThatThrownBy(() -> generator.produce(template, phrases))
            .isInstanceOf(IllegalStateException.class);
}

    @Test
    public void whenHaveRedundantKeyInPhrasesThenGetException() {
        Generator generator = new PhraseGenerator();
        String template = "I am ${name}, Who are ${subject}? ";
        Map<String, String> phrases = new HashMap<>();
        phrases.put("name", "Eduardo");
        phrases.put("city", "London");
        assertThatThrownBy(() -> generator.produce(template, phrases))
                .isInstanceOf(IllegalStateException.class);
    }
}