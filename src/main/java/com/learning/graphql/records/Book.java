package com.learning.graphql.records;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Book(Integer id, String name, Integer pageCount) {
  public static List<Book> books = Arrays.asList(
      new Book(1, "Harry Potter", 563),
      new Book(2, "Lord of the Rings", 721),
      new Book(3, "The Library of the Lost Souls", 459),
      new Book(4, "La Sombra del Viento", 540)
  );

  public static Optional<Book> getBookById(Integer id) {
    return books.stream()
        .filter(book -> book.id.equals(id))
        .findFirst();
  }
}