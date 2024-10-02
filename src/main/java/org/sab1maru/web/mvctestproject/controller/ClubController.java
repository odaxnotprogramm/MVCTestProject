package org.sab1maru.web.mvctestproject.controller;

import org.sab1maru.web.mvctestproject.dto.ClubDto;
import org.sab1maru.web.mvctestproject.models.Club;
import org.sab1maru.web.mvctestproject.service.ClubService;
import org.sab1maru.web.mvctestproject.service.impl.ClubServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/home")
    public String listClubs(Model model) {
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/{clubId}")
    public String clubDetail(@PathVariable("clubId") int clubId, Model model) {
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "clubs-detail";
    }

    @GetMapping("/search")
    public String searchClub(@RequestParam(value = "query") String query, Model model) {
        List<ClubDto> clubs = clubService.searchClub(query);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") int clubId) {
        clubService.delete(clubId);
        return "redirect:/clubs/home";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/new")
    public String saveClub(@ModelAttribute("club") Club club){
        clubService.saveClub(club);
        return "redirect:/clubs/home";
    }

    @GetMapping("/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") int clubId, Model model) {
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "clubs-edit";
    }

    @PostMapping("/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") int id,
                             @ModelAttribute("club") ClubDto club) {
        club.setId(id);
        clubService.updateClub(club);
        return "redirect:/clubs/home";
    }

}
