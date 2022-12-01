package com.br.shopcar.Repository;

import com.br.shopcar.Model.User.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long> {
}
