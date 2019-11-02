package com.Spring.CouponSystem.Beans.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Enum.CouponType;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Integer> {

	@Query("Select c from Coupon c where c.id = :id")
	Coupon findById(int id);

	@Query("Select c from Coupon c where c.type = :type")
	List<Coupon> findByType(CouponType type);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Coupon c WHERE c.id = :id")
	void removeCoupon(@Param("id") int id);

	public List<Coupon> findByEndDate(Date endDate);
	
	@Query("Select c from Coupon c where c.title = :title")
	Coupon findByTitle(String title);
	
}
