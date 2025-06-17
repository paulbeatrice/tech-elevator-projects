package com.techelevator.auctions.services;

import com.techelevator.auctions.model.Auction;
import com.techelevator.util.BasicLogger;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions";
    private RestClient restClient = RestClient.create(API_BASE_URL);


    public Auction add(Auction newAuction) {
        try {
            return restClient.post()
                    .uri(API_BASE_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(newAuction)
                    .retrieve()
                    .body(Auction.class);
        } catch (RestClientResponseException e) {
            System.err.println("API Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
        } catch (ResourceAccessException e) {
            System.err.println("Connection Error: Unable to reach " + API_BASE_URL);
        } catch (Exception e) {
            System.err.println("Unexpected Error: " + e.getMessage());
        }
        return null;
    }

    public boolean update(Auction updatedAuction) {
        try {
            restClient.put()
                    .uri(API_BASE_URL + "/" + updatedAuction.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(updatedAuction)
                    .retrieve()
                    .toBodilessEntity();

            return true;
        } catch (RestClientResponseException e) {
            System.err.println("API Error: " + e.getStatusCode() + e.getResponseBodyAsString());
        } catch (ResourceAccessException e) {
            System.err.println("Connection Error: Unable to reach " + API_BASE_URL);
        } catch (Exception e) {
            System.err.println("Unexpected Error: " + e.getMessage());
        }
        return false;
    }

    public boolean delete(int auctionId) {
        try {
            restClient.delete()
                    .uri(API_BASE_URL + "/" + auctionId)
                    .retrieve()
                    .toBodilessEntity();

            return true;
        } catch (RestClientResponseException e) {
            System.err.println("API Error: " + e.getStatusCode() + e.getMessage());
        } catch (ResourceAccessException e) {
            System.err.println("Connection Error: Unable to reach " + API_BASE_URL);
        } catch (Exception e) {
            System.err.println("Unexpected Erro: " + e.getMessage());
        }
        return false;
    }

    public Auction[] getAllAuctions() {

        Auction[] auctions = null;
        try {
            auctions = restClient.get()
                    .retrieve()
                    .body(Auction[].class);

        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getStatusCode().value() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction getAuction(int id) {

        Auction auction = null;
        try {
            auction = restClient.get()
                    .uri("/" + id)
                    .retrieve()
                    .body(Auction.class);

        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getStatusCode().value() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {

        Auction[] auctions = null;
        try {
            auctions = restClient.get()
                    .uri("?title_like=" + title)
                    .retrieve()
                    .body(Auction[].class);

        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getStatusCode().value() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {

        Auction[] auctions = null;
        try {
            auctions = restClient.get()
                    .uri("?currentBid_lte=" + price)
                    .retrieve()
                    .body(Auction[].class);

        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getStatusCode().value() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

}
