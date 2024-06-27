package com.example.app;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FatSecretAPI {
    private static final String API_KEY = "dc350ae537a640638a571beb69e68f63";
    private static final String API_SECRET = "d89171995ff346bfa99b5fe8695f74a2";
    private static final String API_URL = "https://platform.fatsecret.com/rest/server.api";


    public String searchFood(String food) {
        try {
            // Get access token
            String accessToken = getAccessToken();

            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Create request
            HttpGet request = new HttpGet(API_URL + "?method=foods.search&search_expression=" + food + "&format=json");
            request.addHeader("Authorization", "Bearer " + accessToken);

            // Execute request
            HttpResponse response = httpClient.execute(request);

            // Parse response
            String jsonResponse = EntityUtils.toString(response.getEntity());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonResponse);

            // Close client
            httpClient.close();

            // Return response
            return rootNode.toPrettyString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getAccessToken() {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost post = new HttpPost("https://oauth.fatsecret.com/connect/token");

            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair("grant_type", "client_credentials"));
            urlParameters.add(new BasicNameValuePair("client_id", API_KEY));
            urlParameters.add(new BasicNameValuePair("client_secret", API_SECRET));

            post.setEntity(new UrlEncodedFormEntity(urlParameters));
            HttpResponse response = httpClient.execute(post);
            String jsonResponse = EntityUtils.toString(response.getEntity());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonResponse);
            return rootNode.path("access_token").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getFoodDetails(String foodId) {
        String accessToken = getAccessToken();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(API_URL + "/food/" + foodId);
        request.addHeader("Authorization", "Bearer " + accessToken);

        try {
            HttpResponse response = httpClient.execute(request);
            // Handle the response
            // For example, if the response entity is a JSON string:
            String jsonResponse = EntityUtils.toString(response.getEntity());
            // Now you can use jsonResponse
            return jsonResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // return null or a default value if there was an error
    }
    @GetMapping("/searchAndGetDetails/{foodName}")
    public String searchAndGetDetails(String foodName) {
        try {
            // Search for the food by name
            String searchResponse = searchFood(foodName);

            // Parse the response to get the ID of the first food item
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(searchResponse);
            String foodId = rootNode.path("foods").path(0).path("food_id").asText();

            // Get the details of the food item by its ID
            String detailsResponse = getFoodDetails(foodId);

            // Return the details
            return detailsResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
        }
