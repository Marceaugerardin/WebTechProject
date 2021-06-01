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
@Table (name = "GIVEN_OFFER")
public class GivenOffer {

    @Id
    @GeneratedValue
    //@OneToOne(mappedBy="givenOfferID")
    @Column(name="GIVEN_OFFER_ID", unique=true)
    private long givenOfferID;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID")
    private Item givenItemID;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User giverUserID;

    public GivenOffer(User giverUserID, Item givenItemID) {
        super();
        this.giverUserID = giverUserID;
        this.givenItemID = givenItemID;
    }

    public GivenOffer() {

    }


    // Getters & Setters

    public long getId() {
        return givenOfferID;
    }


    public void setId(Integer givenOfferID) {
        this.givenOfferID = givenOfferID;
    }


    public User getGiverUserID() {
        return giverUserID;
    }


    public void setGiverUserID(User giverUserID) {
        this.giverUserID = giverUserID;
    }


    public Item getGivenItemID() {
        return givenItemID;
    }


    public void setGivenItemID(Item givenItemID) {
        this.givenItemID = givenItemID;
    }
}
