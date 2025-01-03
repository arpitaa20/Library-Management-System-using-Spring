package jsp.Spring.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.Spring.Entity.Member;
import jsp.Spring.Respository.MemberRepository;

@Repository
public class MemberDAO {
	
	@Autowired
	private MemberRepository memberRepository;
	

	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}
	
	public List<Member> getAllMember() {
		List<Member> member = memberRepository.findAll();
		return member;
	}

	public Optional<Member> getMemberById(int id){
		Optional<Member> member = memberRepository.findById(id);
		if(member.isPresent()) {
		    return member;
		}else {
			return null;
		}
	}

	public Optional<Member> deleteMemberById(int id){
		Optional<Member> deleteMember = memberRepository.findById(id);
		if(deleteMember.isPresent()) {
			Member member = deleteMember.get();
		    memberRepository.delete(member);
		    return deleteMember;
		}else {
			return null;
		}
	}

	public Member updateMember(Member member) {
		return memberRepository.save(member);
	}
}
