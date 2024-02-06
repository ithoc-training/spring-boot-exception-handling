package de.ithoc.springboot.exceptionhandling.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemsControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void shouldNotFindItem() {

        String id = "42";

        ResponseEntity<Error> responseEntity =
                restTemplate.getForEntity("/items/" + id, Error.class);

        assertTrue(responseEntity.getStatusCode().is4xxClientError());
        assertEquals("Item not found.", Objects.requireNonNull(responseEntity.getBody()).getMessage());
    }

}
