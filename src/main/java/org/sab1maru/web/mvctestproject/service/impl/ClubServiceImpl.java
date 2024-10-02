package org.sab1maru.web.mvctestproject.service.impl;

import org.sab1maru.web.mvctestproject.dto.ClubDto;
import org.sab1maru.web.mvctestproject.models.Club;
import org.sab1maru.web.mvctestproject.repository.ClubRepository;
import org.sab1maru.web.mvctestproject.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }

    private ClubDto mapToClubDto (Club club){
        return ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .build();
    }

    @Override
    public Club saveClub(Club club) {
        System.out.println(club.getContent() +
                " " + club.getTitle() +
                " " + club.getPhotoUrl() +
                " " + club.getId());
        return clubRepository.save(club);
    }

    @Override
    public List<ClubDto> searchClub(String query) {
        List<Club> clubs = clubRepository.searchClub(query);
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public ClubDto findClubById(Integer clubId) {
        return mapToClubDto(clubRepository.findById(clubId).get());
    }

    @Override
    public void delete(Integer clubId) {
        clubRepository.deleteById((long) clubId);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    private Club mapToClub (ClubDto club){
        return Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
//                .createdOn(club.getCreatedOn())
//                .updatedOn(club.getUpdatedOn())
                .build();
    }
}
