package jsp.Spring.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.Spring.Entity.Loan;
import jsp.Spring.Respository.LoanRepository;


@Repository
public class LoanDAO {
	
	@Autowired
	private LoanRepository loanRepository;
	

	public Loan saveLoan(Loan loan) {
		return loanRepository.save(loan);
	}
	

	public List<Loan> getAllLoan() {
		List<Loan> loan = loanRepository.findAll();
		return loan;
	}

	public Optional<Loan> getLoanById(int id){
		Optional<Loan> loan = loanRepository.findById(id);
		if(loan.isPresent()) {
		    return loan;
		}else {
			return null;
		}
	}
 
	public Optional<Loan> deleteLoanById(int id){
		Optional<Loan> deleteLoan = loanRepository.findById(id);
		if(deleteLoan.isPresent()) {
			Loan loan = deleteLoan.get();
		    loanRepository.delete(loan);
		    return deleteLoan;
		}else {
			return null;
		}
	}

	public Loan updateLoan(Loan loan) {
		return loanRepository.save(loan);
	}
}
