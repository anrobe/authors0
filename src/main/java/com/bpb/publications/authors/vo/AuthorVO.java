package com.bpb.publications.authors.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorVO {
    private Long id;
    private String firstName;
    private String lastName;
}
