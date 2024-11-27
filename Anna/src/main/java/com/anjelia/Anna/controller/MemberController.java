package com.anjelia.Anna.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anjelia.Anna.domain.Member;
import com.anjelia.Anna.form.MemberForm;
import com.anjelia.Anna.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/members")
@Controller
public class MemberController {

	private final MemberService memberService;

//	public MemberController(MemberService memberService) {
//		this.memberService = memberService;
//	}

//	<a href = "/members/new">sign up</a>
//	<a href = "/members"></a>
	
	private Member toEntity(MemberForm memberForm) {
		Member newMember = new Member();
		newMember.setName(memberForm.getName());
		return newMember;
	}
	
	@GetMapping
	public String viewAllMembers(Model model) {
		
		List<Member> memberList = this.memberService.getAllMembers();
		model.addAttribute("members", memberList);
		
		return "members/memberList";
	}
	
	@GetMapping("/new")
	public String viewCreateForm(Model model) {
		MemberForm memberForm = new MemberForm();
		model.addAttribute("memberForm", memberForm);
		
		return "members/createMemberForm"; // 여기는 뷰 파일 이름이 오는거고 병신아
	}
	
	@PostMapping("/new")
	public String createNewMember(@ModelAttribute MemberForm memberForm) {
		
		Member newMember = this.toEntity(memberForm);
		this.memberService.createMember(newMember);
		
		return "redirect:/members"; // ** 리다이렉트에는 URL이 와야한단다 병신아 ***
	}
	
}
