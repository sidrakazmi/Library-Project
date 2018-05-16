package com.lexicon.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lexicon.models.BookModel;
import com.lexicon.models.Member;
import com.lexicon.repositories.MemberService;
import com.lexicon.repositories.MemberRepository;

/**
 * This class has the logic for acting on web requests.
 * 
 * @author Sidra Kazmi
 *
 */
@RestController
@RequestMapping("/members")
public class MemberController {

	@Autowired
	MemberService memberDAO;

	
    /**
     * Creates a member and saves it to the database
     * @param newMember is a Member class item to be added
     * @return a new member added
     */
   // @ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public Member addMember(@Valid @RequestBody Member newMember) {
		return memberDAO.addMember(newMember);
	}
	

	/* Search all members */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Member> getAllMembers() {
		return memberDAO.findAll();
	}
	

	/* Find a member by id */
	@GetMapping("/members/{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable(value = "id") Long memId) {

		Member mem = memberDAO.findOne(memId);

		if (mem == null) {
			return ResponseEntity.notFound().build();
		} else
			return ResponseEntity.ok().body(mem);

	}
	

	/* Update a member by id*/
	@PutMapping("/members/{id}")
	public ResponseEntity<Member> updateMember(@PathVariable(value = "id") Long memId, @Valid @RequestBody Member memDetails) {
         
		Member mem = memberDAO.findOne(memId);
		if (mem == null) {
			return ResponseEntity.notFound().build();
		} else
			mem.setName(memDetails.getName());
		mem.setEmail(memDetails.getEmail());
	
		Member updatedMember = memberDAO.addMember(mem);
		return ResponseEntity.ok().body(mem);	
		}
	
	/* Delete a member */
	@DeleteMapping("/members/{id}")
	public ResponseEntity<Member> deleteMember(@PathVariable(value = "id") Long memId) {
		 
		Member mem = memberDAO.findOne(memId);
		if (mem == null) {
			return ResponseEntity.notFound().build();
		} else
			memberDAO.delete(mem);
		    return ResponseEntity.ok().build();
		}
		
}
