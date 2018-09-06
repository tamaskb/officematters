package com.epam.officematters.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.officematters.model.Comment;
import com.epam.officematters.repository.CommentRepository;
import com.epam.officematters.service.impl.CommentServiceImpl;

public class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepo;

    @InjectMocks
    private CommentServiceImpl commentService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_registerComment() {
        Comment aComment = new Comment("Message", "Author", new Date());
        when(commentRepo.saveComment(aComment, 1)).thenReturn(aComment);
        Comment actual = commentService.registerComment(aComment, 1);

        verify(commentRepo, times(1)).saveComment(aComment, 1);
        assertEquals(aComment, actual);
    }

    private List<Comment> aComments() {
        return Arrays.asList(new Comment("Message 1", "author 1", new Date()),
                new Comment("Message 2", "author 2", new Date()));
    }

    @Test
    public void test_getRequestComments() {
        List<Comment> comments = aComments();
        when(commentRepo.listRequestComments(1)).thenReturn(comments);

        List<Comment> actual = commentService.getRequestComments(1);

        verify(commentRepo, only()).listRequestComments(1);
        Assert.assertThat(actual, is(comments));
    }
}
