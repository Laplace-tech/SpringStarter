package com.anjelia.Anna;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.anjelia.Anna.domain.Member;
import com.anjelia.Anna.repository.MemoryMemberRepository;
import com.anjelia.Anna.service.MemberService;

@SpringBootTest
public class MemberServiceTest {

	private MemoryMemberRepository memberRepository;
	private MemberService memberService;

	@BeforeEach
	public void beforeEach() {
		this.memberRepository = new MemoryMemberRepository();
		this.memberService = new MemberService(memberRepository);
	}

	@AfterEach
	public void afterEach() {
		this.memberRepository.clearRepository();
	}

	@Test
	public void duplicateException() {

		// given
		Member m1 = new Member();
		m1.setName("Anna");
		Member m2 = new Member();
		m2.setName("Anna");

		// when
		IllegalStateException e = assertThrows(IllegalStateException.class, 
				() -> this.memberService.createMember(m2));
		
		// then
		assertThat(e.getMessage()).isEqualTo("Member already exists.");
	}

}
