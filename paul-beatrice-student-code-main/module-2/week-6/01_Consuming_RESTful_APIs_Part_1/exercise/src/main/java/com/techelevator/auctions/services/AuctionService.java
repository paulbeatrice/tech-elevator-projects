package com.techelevator.auctions.services;

import com.techelevator.auctions.model.Auction;
import org.springframework.web.client.RestClient;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions";
    private RestClient restClient;

    public AuctionService() {
        this.restClient = RestClient.create();
    }


    public Auction[] getAllAuctions() {
        return restClient.get()
                .uri(API_BASE_URL)
                .retrieve()
                .body(Auction[].class);
    }

    public Auction getAuction(int id) {
        return restClient.get()
                .uri(API_BASE_URL + "/" + id)
                .retrieve()
                .body(Auction.class);
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        return  restClient.get()
                .uri(API_BASE_URL + "?title={title}", title)
                .retrieve()
                .body(Auction[].class);
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        return restClient.get()
                .uri(API_BASE_URL + "?currentBid_lte={price}", price)
                .retrieve()
                .body(Auction[].class);
    }

}
