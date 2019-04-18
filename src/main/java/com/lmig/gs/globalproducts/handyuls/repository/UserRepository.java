package com.lmig.gs.globalproducts.handyuls.repository;

import com.lmig.gs.globalproducts.handyuls.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNnumber(String nnumber);
}
