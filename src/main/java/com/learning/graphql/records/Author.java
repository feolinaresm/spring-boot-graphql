package com.learning.graphql.records;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Author(Integer id, String name) {
  public static List<Author> authors = Arrays.asList(
      new Author(1, "Heather Fawcett"),
      new Author(2, "Ransom Riggs"),
      new Author(3, "Patrick Süskind"),
      new Author(4, "Frank Herbert")
  );

  public static Optional<Author> getAuthorById(Integer id) {
    return authors.stream()
        .filter(author -> author.id.equals(id))
        .findFirst();
  }
}
