package ru.job4j.quartz;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HabrCareerParse {
    public static final String PREFIX = "/vacancies?page=";
    public static final String SUFFIX = "&q=Java%20developer&type=all";
    private static final String SOURCE_LINK = "https://career.habr.com";

    public static void main(String[] args) throws IOException {
        int pageNumber = 1;
        String fullLink = "%s%s%d%s".formatted(SOURCE_LINK, PREFIX, pageNumber, SUFFIX);
        Connection connection = Jsoup.connect(fullLink);
        Document document = connection.get();
        Elements rows = document.select(".vacancy-card__inner");
        rows.forEach(row -> {
            Element titleElement = row.select(".vacancy-card__title").first();
            Element dateElement = row.select(".vacancy-card__date").first();
            Element linkElement = titleElement.child(0);
            String vacancyName = titleElement.text();
            String link = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
            String vacancyDate = dateElement.child(0).attr("datetime");
            System.out.printf("%s %s %s %n", vacancyName, link, vacancyDate);
        });
    }
}
