package com.test.webtechproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;

@Entity
@Table(name="ITEM")
public class Item {

    @Id
    @GeneratedValue
    @Column(name="ITEM_ID", unique=true)
    private long itemID;
    private String itemName;
    private float itemValue;
    private String description;
    private String state;
    private long numberOfViews;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User userID;
    //private long userID;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="givenItemID",cascade = CascadeType.ALL)
    private Set<GivenOffer> givenOffer;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="takenItemID",cascade = CascadeType.ALL)
    private Set<TakenOffer> takenOffer;


    public Item(long itemID, String itemName, float itemValue, String description, String state, long numberOfViews, User userID,
                Set<GivenOffer> givenOffer, Set<TakenOffer> takenOffer) {
        super();
        this.itemName = itemName;
        this.itemValue = itemValue;
        this.description = description;
        this.state = state;
        this.numberOfViews = numberOfViews;
        this.userID = userID;
        this.givenOffer = givenOffer;
    }

    public Item() {

    }

    // Getters & Setters

    public long getId() {
        return itemID;
    }


    public void setId(Integer itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }


    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public float getItemValue() {
        return itemValue;
    }


    public void setItemValue(float itemValue) {
        this.itemValue = itemValue;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public long getNumberOfViews() {
        return numberOfViews;
    }


    public void setNumberOfViews(long numberOfViews) {
        this.numberOfViews = numberOfViews;
    }

    public User getUserID() {
        return userID;
    }


    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Set<GivenOffer> getGivenOffer()
    {
        return givenOffer;
    }

    public void setGivenOffer(Set<GivenOffer> givenOffer)
    {
        this.givenOffer = givenOffer;
    }

    public Set<TakenOffer> getTakenOffer()
    {
        return takenOffer;
    }

    public void setTakenOffer(Set<TakenOffer> takenOffer)
    {
        this.takenOffer = takenOffer;
    }

}