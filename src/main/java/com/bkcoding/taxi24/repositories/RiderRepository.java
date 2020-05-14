package com.bkcoding.taxi24.repositories;


import com.bkcoding.taxi24.domain.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RiderRepository extends JpaRepository<Rider,Integer> {

}
