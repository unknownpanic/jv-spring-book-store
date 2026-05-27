package com.bookstore.onlinebookstore;

import com.bookstore.onlinebookstore.model.Book;
import com.bookstore.onlinebookstore.service.BookService;
import com.bookstore.onlinebookstore.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private final BookService bookService;

    @Autowired
    public Application(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Book gatsbyBook = new Book();

                gatsbyBook.setTitle("The Great Gatsby");
                gatsbyBook.setAuthor("F. Scott Fitzgerald");
                gatsbyBook.setIsbn("9780743273565");
                gatsbyBook.setPrice(new java.math.BigDecimal("10.99"));
                gatsbyBook.setDescription("A story the mysterious millionaire Jay Gatsby.");
                gatsbyBook.setCoverImage("great_gatsby_classic.jpg");

                bookService.save(gatsbyBook);
                System.out.println(bookService.findAll());
            }
        };
    }

}
