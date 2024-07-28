package com.learning.graphql.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import com.learning.graphql.records.Book;

@GraphQlTest(BookController.class)
class BookControllerTest {

  @Autowired
  private GraphQlTester graphQlTester;

  @Test
  void getBooks() {
    //For this to work, the folder containing the .graphql files to test must be under src/test/resources/graphql-test
    graphQlTester
        .documentName("books") //The one of the file, in this case books.graphql, the extension is assumed
        .execute()
        .path("books") //The path is called "books" as set in the .graphql file line 2
        .entityList(Book.class) //Type of entity returned by the query, in this case Book.class
        .hasSize(4); //Asserts that tha size of the response is 4
  }
}