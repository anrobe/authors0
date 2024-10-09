package com.bpb.publications.authors.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "author", schema = "pub")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 30)
    @Column(name = "first_name", length = 30)
    private String firstName;

    @Size(max = 30)
    @Column(name = "last_name", length = 30)
    private String lastName;
}