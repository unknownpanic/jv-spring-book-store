package com.bookstore.onlinebookstore.repository.impl;

import com.bookstore.onlinebookstore.exception.DataProcessingException;
import com.bookstore.onlinebookstore.model.Book;
import com.bookstore.onlinebookstore.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    @Override
    public Book save(Book book) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't save book: " + book, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<Book> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            String query = "SELECT b FROM Book b WHERE id = :id";
            Query<Book> bookQuery = session.createQuery(query, Book.class);
            bookQuery.setParameter("id", id);
            return bookQuery.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find book with id: " + id, e);
        }
    }

    @Override
    public List<Book> findAll() {
        try (Session session = sessionFactory.openSession()) {
            String query = "SELECT b FROM Book b";
            return session.createQuery(query, Book.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find all books.", e);
        }
    }
}
