package com.example.tbnotice.repository;

import com.example.tbnotice.domain.Tbnotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbnoticeRepository extends JpaRepository<Tbnotice, String> {

}
