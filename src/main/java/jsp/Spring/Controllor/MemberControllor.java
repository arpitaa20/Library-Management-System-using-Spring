package jsp.Spring.Controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.Spring.DTO.ResponseStructure;
import jsp.Spring.Entity.Member;
import jsp.Spring.Service.MemberService;


@RestController
@RequestMapping("/member")
public class MemberControllor {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Member>> saveMember(@RequestBody Member member){
		return memberService.saveMember(member);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Member>>> getAllMember(){
		return memberService.getAllMember();
	}
	
	@GetMapping("/id")
	public ResponseEntity<ResponseStructure<Member>> getMemberById(@PathVariable int id){
		return memberService.getMemberById(id);
	}
	
	@DeleteMapping("/id")
	public ResponseEntity<ResponseStructure<Member>> deleteMemberById(@PathVariable int id){
		return memberService.deleteMemberById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Member>> updateMember(@RequestBody Member member){
		return memberService.updateMember(member);
	}
}
