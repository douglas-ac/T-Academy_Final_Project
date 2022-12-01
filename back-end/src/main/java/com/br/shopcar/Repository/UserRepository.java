package com.br.shopcar.Repository;

import com.br.shopcar.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository< User , Long> {

}
