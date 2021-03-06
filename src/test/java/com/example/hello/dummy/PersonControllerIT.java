package com.example.hello.dummy;

import com.example.hello.dummy.entity.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void findAll_Ok() {

        ResponseEntity<List<Person>> responseEntity = restTemplate.exchange(
            "/persons",
            HttpMethod.GET,
            HttpEntity.EMPTY,
            new ParameterizedTypeReference<List<Person>>() {}
         );
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals(5, responseEntity.getBody().size());
    }

    @Test
    public void findById_Ok() {
        long id = 5L;
        ResponseEntity<Optional<Person>> responseEntity = restTemplate.exchange(
            "/persons/" + id,
            HttpMethod.GET,
            HttpEntity.EMPTY,
            new ParameterizedTypeReference<Optional<Person>>() {}
        );
        String expectedName = "Naruto";
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertTrue(responseEntity.getBody().isPresent());
        Assert.assertEquals(expectedName, responseEntity.getBody().get().getName());
    }
}
