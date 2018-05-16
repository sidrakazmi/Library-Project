package com.lexicon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lexicon.models.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
