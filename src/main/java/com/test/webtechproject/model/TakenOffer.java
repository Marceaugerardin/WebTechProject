package com.test.webtechproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "TAKEN_OFFER")
public class TakenOffer {

    @Id
    @GeneratedValue
    //@OneToOne(mappedBy="takenOfferID")
    @Column(name="TAKEN_OFFER_ID", unique=true)
    private long takenOfferID;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID")
    private Item takenItemID;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User takerUserID;


    public TakenOffer(User takerUserID, Item takenItemID) {
        super();
        this.takerUserID = takerUserID;
        this.takenItemID = takenItemID;
    }

    public TakenOffer() {

    }


    // Getters & Setters

    public long getId() {
        return takenOfferID;
    }


    public void setId(Integer takenOfferID) {
        this.takenOfferID = takenOfferID;
    }


    public User getTakerUserID() {
        return takerUserID;
    }


    public void setTakerUserID(User takerUserID) {
        this.takerUserID = takerUserID;
    }


    public Item getTakenItemID() {
        return takenItemID;
    }


    public void setTakenItemID(Item takenItemID) {
        this.takenItemID = takenItemID;
    }
}
