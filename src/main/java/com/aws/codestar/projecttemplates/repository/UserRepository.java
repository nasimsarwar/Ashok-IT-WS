package com.aws.codestar.projecttemplates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aws.codestar.projecttemplates.entity.UserEntity;





@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findByEmail(String email);
	UserEntity findByUserId(String id);
	UserEntity findUserByEmailVerificationToken(String token);

}
