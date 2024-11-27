package com.anjelia.Anna;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anjelia.Anna.controller.MemberController;
import com.anjelia.Anna.domain.Member;
import com.anjelia.Anna.repository.MemoryMemberRepository;
import com.anjelia.Anna.service.MemberService;

@Configuration
public class SpringConfig {

//	@Bean
//	public MemberController memberController() {
//		System.err.println("hey");
//		return new MemberController(memberService());
//	}
//	
//	@Bean
//	public MemberService memberService() {
//		System.err.println("so");
//		return new MemberService(memberRepository());
//	}
//	
//	@Bean
//	public MemoryMemberRepository memberRepository() {
//		System.err.println("you");
//		return new MemoryMemberRepository();
//	}
	
}
