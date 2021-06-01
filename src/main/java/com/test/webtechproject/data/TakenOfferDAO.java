package com.test.webtechproject.data;

import com.test.webtechproject.model.TakenOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TakenOfferDAO extends JpaRepository<TakenOffer, Long> {

}