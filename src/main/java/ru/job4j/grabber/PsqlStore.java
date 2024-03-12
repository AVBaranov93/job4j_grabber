package ru.job4j.grabber;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store {
    private Connection connection;

    public PsqlStore() {
        init();
    }

    private void init() {
        try (InputStream input = PsqlStore.class.getClassLoader()
                .getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            PreparedStatement statement = connection.prepareStatement("create table if not exists post("
                    + "id serial primary key,"
                    + "name text,"
                    + "text text not null,"
                    + "link text not null,"
                    + "created timestamp not null,"
                    + "unique (text, link, created))");
            statement.execute();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(Post post) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO post (name, text, link, created)"
                            + "VALUES (?, ?, ?, ?) ON CONFLICT (text, link, created) DO UPDATE "
                            + "SET text = ?, link = ?, created = ?");
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getDescription());
            statement.setString(3, post.getLink());
            statement.setTimestamp(4, Timestamp.valueOf(post.getCreated()));
            statement.setString(5, post.getDescription());
            statement.setString(6, post.getLink());
            statement.setTimestamp(7, Timestamp.valueOf(post.getCreated()));
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                post.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    @Override
    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM post")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                posts.add(new Post(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("text"), resultSet.getString("link"),
                        resultSet.getTimestamp("created").toLocalDateTime()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }

    @Override
    public Post findById(int id) {
        Post post = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM post WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    post = new Post(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("text"),
                            resultSet.getString("link"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return post;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        Store store = new PsqlStore();
        store.save(new Post("name1", "text1", "link1", LocalDateTime.now()));
        System.out.println(store.findById(1));
        for (Post post : store.getAll()) {
            System.out.println(post);
        }
    }
}
