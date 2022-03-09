package com.rest.app;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @NonNull
    private String name;

    @NonNull
    private String summary;

    @NonNull
    private int rating;

}
