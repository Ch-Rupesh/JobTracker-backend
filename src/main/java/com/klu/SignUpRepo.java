package com.klu;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpRepo extends JpaRepository<SignUp, String>{
	@EntityGraph(attributePaths = {"resume", "personal", "qualification"})
    Optional<SignUp> findWithDetailsByEmail(String email);
}
