package com.example.ballsquadapi.Unit;

import com.example.ballsquadapi.controllers.AuthorController;
import com.example.ballsquadapi.dtos.authors.AuthorDoc;
import com.example.ballsquadapi.dtos.authors.AuthorResponse;
import com.example.ballsquadapi.entities.*;
import com.example.ballsquadapi.repositories.AuthorRepository;
import com.example.ballsquadapi.clients.OpenLibraryClient;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AuthorDataTest {

    @InjectMocks
    AuthorController authorController;

    @Mock
    AuthorRepository authorRepository;

    @Mock
    OpenLibraryClient openLibraryClient;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFetchAuthors_DataExistsInDatabase() {
        // Arrange: Set up the repository with some dummy authors
        List<Author> existingAuthors = new ArrayList<>();
        existingAuthors.add(new Author("1", "Omer"));
        existingAuthors.add(new Author("2", "Faruk"));
        when(authorRepository.findByAuthorName(anyString())).thenReturn(existingAuthors);

        // Act: Call the getAuthors method
        List<Author> result = authorController.getAuthors("Omer");

        // Assert: Verify that the existing authors are returned
        assertEquals(existingAuthors, result);
        verify(authorRepository, never()).saveAll(anyList());
    }

    @Test
    public void testFetchAuthors_DataDoesNotExistInDatabase() {
        // Arrange: Set up the repository with no existing authors
        when(authorRepository.findByAuthorName(anyString())).thenReturn(Collections.emptyList());
        when(openLibraryClient.getAuthors(anyString())).thenReturn(new AuthorResponse());

        // Act: Call the getAuthors method
        List<Author> result = authorController.getAuthors("Omer");

        // Assert: Verify that the authors are fetched from the client and saved to the database
        assertFalse(result.isEmpty());
        verify(authorRepository, times(1)).saveAll(anyList());
    }


}


