package com.developmentteam.brothersdeliveryapi.repositories.auth;

import com.developmentteam.brothersdeliveryapi.entities.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
