package com.retotecnicobcp.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.retotecnicobcp.demo.Entidad.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query("SELECT i FROM Item i JOIN i.reviews r GROUP BY i HAVING COALESCE(AVG(r.rating), 0) < :rating")
    List<Item> findItemsWithAverageRatingLowerThan(@Param("rating") Double rating);

    
}
