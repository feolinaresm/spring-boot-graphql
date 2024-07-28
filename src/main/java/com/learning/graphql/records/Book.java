package com.learning.graphql.records;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Book(Integer id, String name, Integer pageCount, Integer authorId) {
  public static List<Book> books = Arrays.asList(
      new Book(1, "Dune", 780, 4),
      new Book(2, "The Perfume", 253, 3),
      new Book(3, "Miss Peregrine's Home for Peculiar Children", 348, 2),
      new Book(4, "La Enciclopedia de Hadas de Emily Wilde", 314, 1)
  );

  public static Optional<Book> getBookById(Integer id) {
    return books.stream()
        .filter(book -> book.id.equals(id))
        .findFirst();
  }
}