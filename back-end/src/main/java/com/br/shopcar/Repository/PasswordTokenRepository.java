package com.br.shopcar.Repository;

import com.br.shopcar.Model.User.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Long> {
}
