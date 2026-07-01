package com.github.henriquekriguer.repository;

import com.github.henriquekriguer.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
}
