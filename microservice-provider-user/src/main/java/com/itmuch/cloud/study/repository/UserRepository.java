package com.itmuch.cloud.study.repository;

import com.itmuch.cloud.study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User: Administrator
 * Date: 2018-11-06 11:14
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
