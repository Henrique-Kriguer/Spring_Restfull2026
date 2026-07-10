package com.github.henriquekriguer.unitetests.mapper.mocks;

import com.github.henriquekriguer.data.dto.v1.BooksDTO;
import com.github.henriquekriguer.model.Books;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBooks {

    private Date launchDate(Integer number) {
        return new Date(1700000000000L + number);
    }


    public Books mockEntity() {
        return mockEntity(0);
    }
    
    public BooksDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<Books> mockEntityList() {
        List<Books> Bookss = new ArrayList<Books>();
        for (int i = 0; i < 14; i++) {
            Bookss.add(mockEntity(i));
        }
        return Bookss;
    }

    public List<BooksDTO> mockDTOList() {
        List<BooksDTO> Bookss = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Bookss.add(mockDTO(i));
        }
        return Bookss;
    }
    
    public Books mockEntity(Integer number) {
        Books books = new Books();
        books.setId(number.longValue());
        books.setAuthor("Author Test" + number);
        books.setLaunchDate(launchDate(number));
        books.setPrice(25D);
        books.setTitle("Title Test" + number);
        return books;
    }

    public BooksDTO mockDTO(Integer number) {
        BooksDTO booksDTO = new BooksDTO();
        booksDTO.setId(number.longValue());
        booksDTO.setAuthor("Author Test" + number);
        booksDTO.setLaunchDate(launchDate(number));
        booksDTO.setPrice(25D);
        booksDTO.setTitle("Title Test" + number);
        return booksDTO;
    }

}