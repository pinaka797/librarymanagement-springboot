package com.genpact.librarymanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue
    private long bid;
    private String title;
    private String author;
    private long ISBN;

}
