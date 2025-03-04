package com.example.java_interview_questions.rest;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;



class RestApi {

    private static String URL = "https://jsonplaceholder.typicode.com/posts";

    RestClient restClient = RestClient.create(URL);

    //    Calling Rest API using RestTemplate
    @Test
    void restCall_1() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Post[]> forEntity = restTemplate.getForEntity(URL, Post[].class);
        Arrays.stream(forEntity.getBody())
                .forEach(System.out::println);
    }

    //    Calling Rest API using RestClient, Without CompletableFuture
    @Test
    void restCall_2() {

        Post[] body = restClient.get().uri("/posts")
                .retrieve()
                .body(Post[].class);

        Arrays.stream(body)
                .forEach(System.out::println);
    }

    //    Calling Rest API using RestClient, With CompletableFuture
    @Test
    void restCall_3() {
        CompletableFuture.supplyAsync(() -> {
            Post[] body=null;
            try {
                body = restClient.get().uri("/posts")
                        .retrieve()
                        .body(Post[].class);

                System.out.println(body);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return body;
        }).thenAccept(x ->{
            Arrays.stream(x)
                    .forEach(System.out::println);
        }).join();
    }

    //    Calling Rest API using WebClient, With CompletableFuture

    @Test
    void restCall_4() {
        WebClient client = WebClient.create(URL);

        CompletableFuture.supplyAsync(() -> {

            ResponseEntity<Post[]> response = client.get().retrieve()
                    .toEntity(Post[].class)
                    .block();

            return response.getBody();
        }).thenAccept(responseArray -> {
            Arrays.stream(responseArray)
                    .forEach(System.out::println);
        }).join();
    }
}


record Post(String userId, String id, String title, String body) {
};