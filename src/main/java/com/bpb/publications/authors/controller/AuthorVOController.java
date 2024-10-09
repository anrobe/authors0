package com.bpb.publications.authors.controller;

import com.bpb.publications.authors.service.AuthorService;
import com.bpb.publications.authors.vo.AuthorVO;
import com.bpb.publications.authors.exception.NoRecordsException;
import com.bpb.publications.authors.exception.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/authors")
@Validated
public class AuthorVOController {

    private final AuthorService authorService;

    @Autowired
    public AuthorVOController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AuthorVO>> getAllAuthors() {
        List<AuthorVO> authors = authorService.getAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("getId/{id}")
    public ResponseEntity<AuthorVO> getAuthorById(@PathVariable Long id) {
        AuthorVO author = authorService.getAuthor(id);
        return ResponseEntity.ok(author);
    }

    @PostMapping("/save")
    public ResponseEntity<AuthorVO> createAuthor(@Valid @RequestBody AuthorVO authorVO) {
        AuthorVO createdAuthor = authorService.addAuthor(authorVO);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }

    @PutMapping("getId/{id}")
    public ResponseEntity<AuthorVO> updateAuthor(@PathVariable Long id, @Valid @RequestBody AuthorVO authorVO) {
        AuthorVO updatedAuthor = authorService.updateAuthor(id, authorVO);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoRecordsException.class)
    public ResponseEntity<ErrorMessage> handleNoRecordsException(NoRecordsException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
