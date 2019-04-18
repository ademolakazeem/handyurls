package com.lmig.gs.globalproducts.handyuls.repository;

import com.lmig.gs.globalproducts.handyuls.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
}
