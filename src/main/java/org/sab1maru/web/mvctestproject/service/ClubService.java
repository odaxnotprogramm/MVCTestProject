package org.sab1maru.web.mvctestproject.service;

import org.sab1maru.web.mvctestproject.dto.ClubDto;
import org.sab1maru.web.mvctestproject.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveClub(Club club);

    List<ClubDto> searchClub(String query);

    ClubDto findClubById(Integer clubId);

    void delete(Integer clubId);

    void updateClub(ClubDto club);
}
