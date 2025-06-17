package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao auctionDao;

    public AuctionController() {
        this.auctionDao = new MemoryAuctionDao();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Auction> getAllAuctions(
        @RequestParam(value = "title_like", required = false, defaultValue = "") String titleLike,
        @RequestParam(value = "currentBid_lte", required = false, defaultValue = "0") double currentBidLte) {

        if (!titleLike.isEmpty() && currentBidLte > 0) {
            return auctionDao.getAuctionsByTitleAndMaxBid(titleLike, currentBidLte);
        } else if (!titleLike.isEmpty()) {
            return auctionDao.getAuctionsByTitle(titleLike);
        } else if (currentBidLte > 0) {
            return auctionDao.getAuctionsByMaxBid(currentBidLte);
        } else {
            return auctionDao.getAuctions();
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return auctionDao.getAuctionById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction) {
        return auctionDao.createAuction(auction);
    }




}
