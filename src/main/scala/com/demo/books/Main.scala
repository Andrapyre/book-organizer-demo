package com.demo.books

import com.demo.books.models.{Author, Book}

object Main {
  def organize(books: Seq[Book]): Map[Author, Seq[Book]] = {
    var finalBooks: scala.collection.mutable.Map[Author, Seq[Book]] = scala.collection.mutable.Map.empty

    books.foreach(currentBook => {
      val currentAuthorBooks = finalBooks.getOrElse(currentBook.author, Seq.empty)
      val isBookAlreadyRecorded = currentAuthorBooks.find(book => book.title == currentBook.title).fold(false)(_ => true)

      if (!isBookAlreadyRecorded) {
        if (currentAuthorBooks.isEmpty) {
          finalBooks += (currentBook.author -> Seq(currentBook))
        } else {
          finalBooks(currentBook.author) = currentAuthorBooks :+ currentBook
        }
      }
    })

    finalBooks.toMap
  }
}
