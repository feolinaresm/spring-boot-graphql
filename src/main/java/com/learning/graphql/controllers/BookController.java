package com.learning.graphql.controllers;

import com.learning.graphql.records.Author;
import java.util.List;
import com.learning.graphql.records.Book;
import java.util.Optional;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

  @QueryMapping
  public List<Book> books (){
    return Book.books;
  }

  @QueryMapping
  public Optional<Book> bookById(@Argument Integer id) {
    return Book.getBookById(id);
  }

  @SchemaMapping //This one is used to define a schema inside our already defined queries
  public Optional<Author> author(Book book) {
    return Author.getAuthorById(book.authorId());
  }
}
