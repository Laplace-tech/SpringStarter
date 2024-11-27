package com.anjelia.Anna.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anjelia.Anna.domain.Member;
import com.anjelia.Anna.repository.MemoryMemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemoryMemberRepository memberRepository;

//	public MemberService(MemoryMemberRepository memberRepository) { 
//		this.memberRepository = memberRepository;
//	}
	
	// *** Helper Methods ***

	private boolean isDuplicateMember(Member member) {
		return memberRepository.findByName(member.getName()).isPresent();
	}

	private Member findMemberById(Long memberId) {
		return memberRepository.findById(memberId)
				.orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + memberId));
	}

	private Member findMemberByName(String memberName) {
		return memberRepository.findByName(memberName)
				.orElseThrow(() -> new IllegalArgumentException("Member not found with name: " + memberName));
	}

	// *** CRUD Operations ***

	public Long createMember(Member newMember) {
		if (isDuplicateMember(newMember)) {
			throw new IllegalStateException("Member already exists.");
		}
		memberRepository.save(newMember);
		return newMember.getId();
	}

	public List<Member> getAllMembers() {
		return memberRepository.findAll();
	}

	public Member getMemberById(Long memberId) {
		return findMemberById(memberId);
	}

	public Member getMemberByName(String memberName) {
		return findMemberByName(memberName);
	}

}
