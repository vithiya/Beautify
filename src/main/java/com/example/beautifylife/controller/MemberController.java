package com.example.beautifylife.controller;

import com.example.beautifylife.model.Member;
import com.example.beautifylife.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String getMemberPage(Model model){
        model.addAttribute("listMembers",memberService.getAllMembers());
        return "memberlist";
    }

    @GetMapping("/newMemberForm")
    public String showNewMemberForm(Model model){
        Member member = new Member();
        model.addAttribute("member", member);
        return "new_member";
    }
    @PostMapping("/saveMember")
    public String saveMember(@ModelAttribute ("member") Member member){
        memberService.saveMember(member);
        return "redirect:/";
    }

    @GetMapping("/editMemberForm/{id}")
    public String showEditMemberForm(@PathVariable(value = "id") long id ,Model model){
        Member member = memberService.getMemberById(id);
        model.addAttribute("member", member);
        return "edit_member";
    }

    @PostMapping("/updateMember")
    public String updateMember(@ModelAttribute ("member") Member member){
        memberService.saveMember(member);
        return "redirect:/";
    }

    @GetMapping("/deleteMember/{id}")
    public String removeMember(@PathVariable(value = "id") long id ){
        memberService.removeMember(id);
        return "redirect:/";
    }
}
