package com.github.henriquekriguer.services;

import com.github.henriquekriguer.data.dto.v1.BooksDTO;
import com.github.henriquekriguer.exception.RequiredObjectIsNullException;
import com.github.henriquekriguer.model.Books;
import com.github.henriquekriguer.repository.BooksRepository;
import com.github.henriquekriguer.unitetests.mapper.mocks.MockBooks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.hateoas.Link;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)


class BooksServicesTest {

    MockBooks input;

    @InjectMocks
    BooksServices service;

    @Mock
    BooksRepository repository;

    @BeforeEach
    void setUp() {
        input = new MockBooks();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        List<Books> list = input.mockEntityList();
        when(repository.findAll()).thenReturn(list);
        List<BooksDTO> books = service.findAll();
        assertNotNull(books);
        assertEquals(14, books.size());

        var BooksOne = books.get(1);
        assertNotNull(BooksOne);
        assertNotNull(BooksOne.getId());
        assertNotNull(BooksOne.getLinks());
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("/api/Books/v1/1")
                                && link.getType().equals("GET")
                )
        );

        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("/api/Books/v1")
                                && link.getType().equals("GET")
                )
        );
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("/api/Books/v1")
                                && link.getType().equals("POST")
                )
        );
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("/api/Books/v1/1")
                                && link.getType().equals("PUT")
                )
        );
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("/api/Books/v1/1")
                                && link.getType().equals("DELETE")
                )
        );
        assertEquals("Author Test1", BooksOne.getAuthor());
        assertEquals(25D, BooksOne.getPrice());
        assertEquals("Title Test1", BooksOne.getTitle());
        assertNotNull(BooksOne.getLaunchDate());
        var BooksFour = books.get(4);
        assertNotNull(BooksFour);
        assertNotNull(BooksFour.getId());
        assertNotNull(BooksFour.getLinks());
        assertNotNull(BooksFour.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("/api/Books/v1/4")
                                && link.getType().equals("GET")
                )
        );

        assertNotNull(BooksFour.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("/api/Books/v1")
                                && link.getType().equals("GET")
                )
        );
        assertNotNull(BooksFour.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("/api/Books/v1")
                                && link.getType().equals("POST")
                )
        );
        assertNotNull(BooksFour.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("/api/Books/v1/4")
                                && link.getType().equals("PUT")
                )
        );
        assertNotNull(BooksFour.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("/api/Books/v1/4")
                                && link.getType().equals("DELETE")
                )
        );
        assertEquals("Author Test1", BooksOne.getAuthor());
        assertEquals(25D, BooksOne.getPrice());
        assertEquals("Title Test1", BooksOne.getTitle());
        assertNotNull(BooksOne.getLaunchDate());

    }

    @Test
    void findById() {
        Books Books = input.mockEntity(1);
        Books.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(Books));
        var BooksOne = service.findById(1L);
        assertNotNull(BooksOne);
        assertNotNull(BooksOne.getId());
        assertNotNull(BooksOne.getLinks());
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("self")
                            && link.getHref().endsWith("/api/Books/v1/1")
                            && link.getType().equals("GET")
                )
        );

        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("findAll")
                            && link.getHref().endsWith("/api/Books/v1")
                            && link.getType().equals("GET")
                )
        );
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("create")
                            && link.getHref().endsWith("/api/Books/v1")
                            && link.getType().equals("POST")
                )
        );
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("update")
                            && link.getHref().endsWith("/api/Books/v1/1")
                            && link.getType().equals("PUT")
                )
        );
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("delete")
                            && link.getHref().endsWith("/api/Books/v1/1")
                            && link.getType().equals("DELETE")
                )
        );

        assertEquals("Author Test1", BooksOne.getAuthor());
        assertEquals(25D, BooksOne.getPrice());
        assertEquals("Title Test1", BooksOne.getTitle());
        assertNotNull(BooksOne.getLaunchDate());
    }

    @Test
    void create() {

        Books Books = input.mockEntity(1);
        Books persisted = Books;
        persisted.setId(1L);

        BooksDTO dto = input.mockDTO(1);
        when(repository.save(Books)).thenReturn(persisted);
        var BooksOne = service.create(dto);
        assertNotNull(BooksOne);
        assertNotNull(BooksOne.getId());
        assertNotNull(BooksOne.getLinks());
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("/api/Books/v1/1")
                                && link.getType().equals("GET")
                )
        );

        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("/api/Books/v1")
                                && link.getType().equals("GET")
                )
        );
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("/api/Books/v1")
                                && link.getType().equals("POST")
                )
        );
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("/api/Books/v1/1")
                                && link.getType().equals("PUT")
                )
        );
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("/api/Books/v1/1")
                                && link.getType().equals("DELETE")
                )
        );

        assertEquals("Author Test1", BooksOne.getAuthor());
        assertEquals(25D, BooksOne.getPrice());
        assertEquals("Title Test1", BooksOne.getTitle());
        assertNotNull(BooksOne.getLaunchDate());

    }
    @Test
    void testCreateWithNunBooks() {
       Exception exception = assertThrows(RequiredObjectIsNullException.class,
               () -> {
                     service.create(null);
               });

                String expectedMessage = "Is Not allowed to persist a null object!";
                String actualMessage = exception.getMessage();
                assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    void update() {
        Books Books = input.mockEntity(1);
        Books persisted = Books;
        persisted.setId(1L);

        BooksDTO dto = input.mockDTO(1);
        when(repository.findById(1L)).thenReturn(Optional.of(Books));
        when(repository.save(Books)).thenReturn(persisted);
        var BooksOne = service.update(dto);
        assertNotNull(BooksOne);
        assertNotNull(BooksOne.getId());
        assertNotNull(BooksOne.getLinks());
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("/api/Books/v1/1")
                                && link.getType().equals("GET")
                )
        );

        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("/api/Books/v1")
                                && link.getType().equals("GET")
                )
        );
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("/api/Books/v1")
                                && link.getType().equals("POST")
                )
        );
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("/api/Books/v1/1")
                                && link.getType().equals("PUT")
                )
        );
        assertNotNull(BooksOne.getLinks().stream()
                .anyMatch((Link link) ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("/api/Books/v1/1")
                                && link.getType().equals("DELETE")
                )
        );

        assertEquals("Author Test1", BooksOne.getAuthor());
        assertEquals(25D, BooksOne.getPrice());
        assertEquals("Title Test1", BooksOne.getTitle());
        assertNotNull(BooksOne.getLaunchDate());

    }
    @Test
    void testUpdateWithNunBooks() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class,
                () -> {
                    service.update(null);
                });

        String expectedMessage = "Is Not allowed to persist a null object!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    void delete() {
        Books Books = input.mockEntity(1);
        Books.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(Books));
        service.delete(1L);
        verify(repository, times(1)).findById(anyLong());
        verify(repository, times(1)).delete(any(Books.class));
        verifyNoMoreInteractions(repository);
    }
}