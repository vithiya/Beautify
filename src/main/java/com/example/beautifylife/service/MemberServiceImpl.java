package com.example.beautifylife.service;

import com.example.beautifylife.model.Member;
import com.example.beautifylife.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void removeMember(long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member getMemberById(long id) {
        Optional<Member> optional = memberRepository.findById(id);
        Member member = null;
        if(optional.isPresent()){
            member = optional.get();
        } else {
            throw new RuntimeException("Member is not available with id : "+ id);
        }
        return member;
    }
}
