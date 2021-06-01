package com.test.webtechproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table (name = "OFFER")
public class Offer {

    @Id
    @GeneratedValue
    @Column(name="OFFER_ID", unique=true)
    private long offerID;
    private LocalDateTime timeStamp;
    private String comment;
    private String status;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "GIVEN_OFFER_ID")
    private GivenOffer givenOfferID;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "TAKEN_OFFER_ID")
    private TakenOffer takenOfferID;


    public Offer(GivenOffer givenOfferID, TakenOffer takenOfferID, LocalDateTime timeStamp, String comment, String status) {
        super();
        this.givenOfferID = givenOfferID;
        this.takenOfferID = takenOfferID;
        this.setTimeStamp(LocalDateTime.now());
        this.comment = comment;
        this.status = status;
    }

    public Offer() {

    }


    // Getters & Setters

    public long getId() {
        return offerID;
    }


    public void setId(Integer offerID) {
        this.offerID = offerID;
    }

    public GivenOffer getGivenOfferID() {
        return givenOfferID;
    }


    public void setGivenOfferID(GivenOffer givenOfferID) {
        this.givenOfferID = givenOfferID;
    }


    public TakenOffer getTakenOfferID() {
        return takenOfferID;
    }


    public void setTakenOfferID(TakenOffer takenOfferID) {
        this.takenOfferID = takenOfferID;
    }


    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }


    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

}
