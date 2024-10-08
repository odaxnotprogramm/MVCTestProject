package org.sab1maru.web.mvctestproject.repository;

import org.sab1maru.web.mvctestproject.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findById(Integer id);

    @Query("select c from Club c where c.title like concat('%',:query,'%')")
    List<Club> searchClub(String query);
}