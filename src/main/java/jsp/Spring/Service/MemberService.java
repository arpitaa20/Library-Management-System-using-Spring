package jsp.Spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.Spring.DAO.MemberDAO;
import jsp.Spring.DTO.ResponseStructure;
import jsp.Spring.Entity.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public ResponseEntity<ResponseStructure<Member>> saveMember(Member member){
		Member recievedMember = memberDAO.saveMember(member);
		
		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(recievedMember);
		
		return new ResponseEntity<ResponseStructure<Member>> (structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Member>>> getAllMember(){
		List<Member> member = memberDAO.getAllMember();
		
		ResponseStructure<List<Member>> structure= new ResponseStructure<List<Member>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(member);
		return new ResponseEntity<ResponseStructure<List<Member>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Member>> getMemberById(int id){
		Optional<Member> getMember = memberDAO.getMemberById(id);
		
		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		if(getMember.isPresent()) {
		    structure.setStatusCode(HttpStatus.FOUND.value());
		    structure.setMessage("Found");
		    structure.setData(getMember.get());
		    return new ResponseEntity<ResponseStructure<Member>> (structure, HttpStatus.FOUND);
		}else {
			return null;
		}	
	}
	
	public ResponseEntity<ResponseStructure<Member>> deleteMemberById(int id){
		Optional<Member> deleteMember = memberDAO.deleteMemberById(id);
		
		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		if(deleteMember.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Deleted");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Member>>(structure, HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<Member>> updateMember(Member member){
		Member updateMember = memberDAO.saveMember(member);
		
		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(updateMember);
		return new ResponseEntity<ResponseStructure<Member>>(structure, HttpStatus.OK);
	}


}
