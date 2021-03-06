package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer> {
    List<Banner> findByDeletedNot(boolean deleted);

    @Query("SELECT b FROM Banner b JOIN b.category c WHERE c.reqName = :reqName")
    List<Banner> getBannerByNameCategory(@Param("reqName") String reqName);

}
