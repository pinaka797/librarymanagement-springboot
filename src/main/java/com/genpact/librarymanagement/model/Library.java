package com.genpact.librarymanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Library {
    @Id
    @GeneratedValue
    private long lid;
    private String libraryName;
    private String contactNo;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Book> listOfBooks;
}
