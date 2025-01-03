package jsp.Spring.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.Spring.Entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
	

}
