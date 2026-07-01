package com.github.henriquekriguer.data.dto.v1;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class BooksDTO extends RepresentationModel<BooksDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String author;
    private String launch_date;
    private Long price;
    private String title;

    public BooksDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(String launch_date) {
        this.launch_date = launch_date;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BooksDTO booksDTO = (BooksDTO) o;
        return Objects.equals(getId(), booksDTO.getId()) && Objects.equals(getAuthor(), booksDTO.getAuthor()) && Objects.equals(getLaunch_date(), booksDTO.getLaunch_date()) && Objects.equals(getPrice(), booksDTO.getPrice()) && Objects.equals(getTitle(), booksDTO.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getAuthor(), getLaunch_date(), getPrice(), getTitle());
    }
}
