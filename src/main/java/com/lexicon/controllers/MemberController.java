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
	MemberService memberService;

	
    /**
     * Creates a new member and saves it to the database
     * @param newMember is a Member class item to be added
     * @return a new member added
     */
   // @ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public Member addMember(@Valid @RequestBody Member newMember) {
		return memberService.addMember(newMember);
	}
	


    /**
     * Updates a members details and saves it to the database
     * @param memberUpdates is a Book class item to be added
     * @return updatedMember as an object
     */
	@PutMapping("/update/{id}")
	public ResponseEntity<Member> updateMember(@PathVariable(value = "id") Long memId, @Valid @RequestBody Member memberUpdates) {
         
		Member mem = memberService.findOne(memId);
		if (mem == null) {
			return ResponseEntity.notFound().build();
		} else
			mem.setName(memberUpdates.getName());
		mem.setEmail(memberUpdates.getEmail());
	
		Member updatedMember = memberService.addMember(mem);
		return ResponseEntity.ok().body(mem);	
		}
	

    /**
     * Finds a member from the database
     * @param memId is a Member class item to be searched for
     * @return updatedMember as response
     */
	@GetMapping("/members/{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable(value = "id") Long memId) {

		Member foundMember = memberService.findOne(memId);

		if (foundMember == null) {
			return ResponseEntity.notFound().build();
		} else
			return ResponseEntity.ok().body(foundMember);

	}
	
	
	/**
     * Deletes a member from the database
     * @param memId is a Member class item to be deleted
     * @return a member deleted
     */
	@DeleteMapping("/members/{id}")
	public ResponseEntity<Member> deleteMember(@PathVariable(value = "id") Long memId) {
		 
		Member mem = memberService.findOne(memId);
		if (mem == null) {
			return ResponseEntity.notFound().build();
		} else
			memberService.delete(mem);
		    return ResponseEntity.ok().build();
		}
	
	 /**
     * Lists all the members in the database
     * @return List of all the members
     */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Member> getAllMembers() {
		return memberService.findAll();
	}
		
}
