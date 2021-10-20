package com.example.LeaveManagement.repository;

import com.example.LeaveManagement.model.UserDetails;
import com.example.LeaveManagement.request.UserRequest;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer>, PagingAndSortingRepository<UserDetails,Integer>, QueryByExampleExecutor<UserDetails> {
      Optional<UserDetails>findByName(String Name);
      List<UserDetails>findByreportsTo(String name);
      Page<UserDetails>findByreportsTo(String name,Pageable pageable);
      public UserRequest save(UserRequest userRequest);
      Optional<UserDetails>findById(Long id);

}

