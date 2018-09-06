package com.epam.officematters.service;

import com.epam.officematters.model.Request;
import com.epam.officematters.repository.RequestRepository;
import com.epam.officematters.service.exception.RequestAlreadyExistsException;
import com.epam.officematters.service.impl.RequestServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RequestServiceImplTest {

    @Mock
    private RequestRepository requestRepo;

    @InjectMocks
    private RequestServiceImpl requestService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_register() throws RequestAlreadyExistsException {
        Request aRequest = new Request("full name","email@addr.ess","subject","problem description");
        when(requestRepo.save(aRequest)).thenReturn(aRequest);
        Request actual = requestService.register(aRequest);

        verify(requestRepo, times(1)).save(aRequest);
        assertEquals(aRequest, actual);
    }

    @Test
    public void test_getRequestById() {

    }



    }