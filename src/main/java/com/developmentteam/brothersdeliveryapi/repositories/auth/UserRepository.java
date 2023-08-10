package com.developmentteam.brothersdeliveryapi.repositories.auth;

import com.developmentteam.brothersdeliveryapi.entities.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,  Long> {
}
