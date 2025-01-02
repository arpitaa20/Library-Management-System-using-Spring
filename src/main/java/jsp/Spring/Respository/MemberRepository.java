package jsp.Spring.Respository;


import org.springframework.data.jpa.repository.JpaRepository;

import jsp.Spring.Entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{

}
