package com.test.webtechproject.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name="USER")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name="USER_ID", unique=true)
    private long userID;
    private String username;
    private String surname;
    private String lastName;
    private byte userRanking;
    private String mail;
    private String password;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @OneToMany(fetch = FetchType.EAGER,mappedBy="userID",cascade = CascadeType.ALL)
    private Set<Comment> comment;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="userID",cascade = CascadeType.ALL)
    private Set<Item> item;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="giverUserID",cascade = CascadeType.ALL)
    private Set<GivenOffer> givenOffer;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="takerUserID",cascade = CascadeType.ALL)
    private Set<TakenOffer> takenOffer;

    public User(String username, String surname, String lastName, byte userRanking, String mail, String password, Set<Comment> comment, Set<Item> item,
                Set<GivenOffer> givenOffer, Set<TakenOffer> takenOffer) {
        super();

        this.surname = surname;
        this.lastName = lastName;
        this.userRanking = userRanking;
        this.mail = mail;
        this.password = password;
        this.comment = comment;
        this.item = item;
        this.givenOffer = givenOffer;
        this.takenOffer = takenOffer;
    }

    public User() {

    }
    @Override
    public String getUsername() {
        //required by UserDetails for authentication but email is used instead
        return mail;
    }

    public Boolean comparePassword(String password) {
        return this.password.equals(password);
    }




    // Getter and Setter

    public long getUserId() { return userID; }

    public void setUserId(Integer userID) { this.userID = userID; }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getUserRanking() {
        return userRanking;
    }

    public void setUserRanking(byte userRanking) {
        this.userRanking = userRanking;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Comment> getComment()
    {
        return comment;
    }

    public void setComment(Set<Comment> comment)
    {
        this.comment = comment;
    }

    public Set<Item> getItem()
    {
        return item;
    }

    public void setItem(Set<Item> item)
    {
        this.item = item;
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

    public void setTakenOffer(Set<TakenOffer> TakenOffer)
    {
        this.takenOffer = TakenOffer;
    }


    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}