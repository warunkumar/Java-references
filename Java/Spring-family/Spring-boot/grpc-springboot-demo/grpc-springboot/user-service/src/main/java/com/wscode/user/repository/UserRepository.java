package com.wscode.user.repository;

import com.wscode.user.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Warun
 * @createdOn 11-10-2021
 **/
@Repository
public interface UserRepository extends JpaRepository<UserData,String> {


}
