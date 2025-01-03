package jsp.Spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.Spring.DAO.LoanDAO;
import jsp.Spring.DTO.ResponseStructure;
import jsp.Spring.Entity.Loan;

@Service
public class LoanService {
	@Autowired
	private LoanDAO loanDAO;
	
	public ResponseEntity<ResponseStructure<Loan>> saveLoan(Loan loan){
		Loan recievedLoan = loanDAO.saveLoan(loan);
		
		ResponseStructure<Loan> structure = new ResponseStructure<Loan>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(recievedLoan);
		
		return new ResponseEntity<ResponseStructure<Loan>> (structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Loan>>> getAllLoan(){
		List<Loan> loan = loanDAO.getAllLoan();
		
		ResponseStructure<List<Loan>> structure= new ResponseStructure<List<Loan>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(loan);
		return new ResponseEntity<ResponseStructure<List<Loan>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Loan>> getLoanById(int id){
		Optional<Loan> getLoan = loanDAO.getLoanById(id);
		
		ResponseStructure<Loan> structure = new ResponseStructure<Loan>();
		if(getLoan.isPresent()) {
		    structure.setStatusCode(HttpStatus.FOUND.value());
		    structure.setMessage("Found");
		    structure.setData(getLoan.get());
		    return new ResponseEntity<ResponseStructure<Loan>> (structure, HttpStatus.FOUND);
		}else {
			return null;
		}	
	}
	
	public ResponseEntity<ResponseStructure<Loan>> deleteLoanById(int id){
		Optional<Loan> deleteLoan = loanDAO.deleteLoanById(id);
		
		ResponseStructure<Loan> structure = new ResponseStructure<Loan>();
		if(deleteLoan.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Deleted");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Loan>>(structure, HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<Loan>> updateLoan(Loan loan){
		Loan updateLoan = loanDAO.saveLoan(loan);
		
		ResponseStructure<Loan> structure = new ResponseStructure<Loan>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(updateLoan);
		return new ResponseEntity<ResponseStructure<Loan>>(structure, HttpStatus.OK);
	}


}
