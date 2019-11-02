package com.Spring.CouponSystem.Beans.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.CouponSystem.Beans.Income;

@Repository
public interface IncomeRepo extends JpaRepository<Income, Long>{
	
	Income findClientById(int id);

//	Income storeIncome(Income income);
	
//	List<Income> allIncome();

//	Income viewIncomeByCustomer(int customerId) throws Exception;

//	Income viewIncomeByCompany(int companyId) throws Exception;

//	Income findAllByClientId(int customerId);
	
}


