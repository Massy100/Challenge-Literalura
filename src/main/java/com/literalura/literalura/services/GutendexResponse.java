package com.literalura.literalura.services;

import java.util.List;

public class GutendexResponse {
    private int count;
    private String next;
    private String previous;
    private List<Book> results;

    // Getters y Setters para todos los campos

    public static class Book {
        private int id;
        private String title;
        private List<Author> authors;
        // Otros campos relevantes como subjects, languages, etc.

        // Getters y Setters para todos los campos de Book

        public static class Author {
            private String name;
            private int birth_year;
            private int death_year;

            // Getters y Setters para todos los campos de Author
        }
    }
}
