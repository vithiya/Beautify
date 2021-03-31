package com.example.beautifylife.service;

import com.example.beautifylife.model.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAllMembers();

    void saveMember(Member member);

    void removeMember(long id);

    Member getMemberById(long id);
}
