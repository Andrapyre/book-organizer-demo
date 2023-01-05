package com.demo.books

import com.demo.books.models.{Author, Book}
import org.scalatest.freespec.AnyFreeSpec

class MainSpec extends AnyFreeSpec {
    "#organize" - {
      "should sort books by author" in {
        val author1 = Author("Bill", "Hagermann")
        val author2 = Author("Simon", "Smith")

        val book1 = Book(author1, "The dark hour")
        val book2 = Book(author1, "Actually, everything's ok")
        val book3 = Book(author2, "Self-help guide - Come here for help!")
        val book4 = Book(author1, "The dark hour draws near")
        val initialBooks = Seq(book1, book2, book3, book4)

        val finalBooks = Main.organize(initialBooks)

        val expectedBooks = Map(author1 -> Seq(book1, book2, book4), author2 -> Seq(book3))

        assert(finalBooks == expectedBooks)
      }

      "should eliminate duplicate books" in {
        val author1 = Author("Bill", "Hagermann")

        val book1 = Book(author1, "The dark hour")
        val book2 = Book(author1, "The dark hour")
        val initialBooks = Seq(book1, book2)

        val finalBooks = Main.organize(initialBooks)

        val expectedBooks = Map(author1 -> Seq(book1))

        assert(finalBooks == expectedBooks)
      }
    }
}
