package com.example.ballsquadapi.Unit;

import com.example.ballsquadapi.Controllers.AuthorController;
import com.example.ballsquadapi.Models.*;
import com.example.ballsquadapi.Repositories.AuthorRepository;
import com.example.ballsquadapi.Client.OpenLibraryClient;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

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
    public void testGetAuthors_WhenAuthorsExistInDB() {
        String query = "test123";
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("key1", query));
        authors.add(new Author("key2", query));

        when(authorRepository.findByAuthorName(query)).thenReturn(authors);

        List<Author> result = authorController.getAuthors(query);

        assertEquals(authors.size(), result.size());
        assertEquals(authors.get(0).getAuthorName(), result.get(0).getAuthorName());
        assertEquals(authors.get(1).getAuthorName(), result.get(1).getAuthorName());
    }

    @Test
    public void testGetAuthors_WhenAuthorsDoNotExistInDB() {
        String query = "test123";
        List<Author> authors = new ArrayList<>();

        when(authorRepository.findByAuthorName(query)).thenReturn(authors);

        AuthorResponse response = new AuthorResponse();
        List<AuthorDoc> docs = new ArrayList<>();
        docs.add(new AuthorDoc("key1", query));
        docs.add(new AuthorDoc("key2", query));
        response.setDocs(docs);

        when(openLibraryClient.getAuthors(query)).thenReturn(response);

        List<Author> result = authorController.getAuthors(query);

        assertEquals(docs.size(), result.size());
        assertEquals(docs.get(0).getName(), result.get(0).getAuthorName());
        assertEquals(docs.get(1).getName(), result.get(1).getAuthorName());

        verify(authorRepository, times(2)).save(org.mockito.ArgumentMatchers.any(Author.class));
    }
}


