package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.exception.DaoException;
import com.techelevator.auctions.model.Auction;
import jakarta.annotation.security.PermitAll;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/auctions")
@PreAuthorize("isAuthenticated()")
public class AuctionController {

    private AuctionDao auctionDao;

    public AuctionController() {
        this.auctionDao = new MemoryAuctionDao();
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    @PreAuthorize("permitAll()")
    public List<Auction> list(@RequestParam(defaultValue = "") String title_like, @RequestParam(defaultValue = "0") double currentBid_lte) {

        if (!title_like.equals("")) {
            return auctionDao.getAuctionsByTitle(title_like);
        }
        if (currentBid_lte > 0) {
            return auctionDao.getAuctionsByMaxBid(currentBid_lte);
        }

        return auctionDao.getAuctions();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        Auction auction = auctionDao.getAuctionById(id);
        if (auction == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction Not Found");
        } else {
            return auction;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    @PreAuthorize("hasRole('CREATOR') or hasRole('ADMIN')")
    public Auction create(@Valid @RequestBody Auction auction) {
        return auctionDao.createAuction(auction);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasRole('CREATOR') or hasRole('ADMIN')")
    public Auction update(@Valid @RequestBody Auction auction, @PathVariable int id) {
        // The id on the path takes precedence over the id in the request body, if any
        auction.setId(id);
        try {
            Auction updatedAuction = auctionDao.updateAuction(auction);
            return updatedAuction;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction Not Found");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id) {
        auctionDao.deleteAuctionById(id);
    }

    @RequestMapping(path = "/whoami")
    @PreAuthorize("isAuthenticated()")
    public String whoAmI(Principal principal) {
        return principal.getName();
    }

}
