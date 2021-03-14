package com.aws.codestar.projecttemplates.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aws.codestar.projecttemplates.entity.AddressEntity;
import com.aws.codestar.projecttemplates.entity.UserEntity;
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    List<AddressEntity> findAllByUserDetails(UserEntity userEntity);

     AddressEntity findByAddressId(String id);

}
