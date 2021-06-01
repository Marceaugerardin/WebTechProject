package com.test.webtechproject.data;

import com.test.webtechproject.model.GivenOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface GivenOfferDAO extends JpaRepository<GivenOffer, Long> {

}
