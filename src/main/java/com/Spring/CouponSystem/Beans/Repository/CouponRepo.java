package com.Spring.CouponSystem.Beans.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Enum.CouponType;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Integer> {

	@Query("Select c from Coupon c where c.id = :id")
	Coupon findById(int id);

	@Query("Select c from Coupon c where c.type = :type")
	List<Coupon> findByType(CouponType type);

	public List<Coupon> findByEndDate(Date endDate);

	@Query("Select c from Coupon c where c.title = :title")
	Coupon findByTitle(String title);

	@Query("SELECT c from Company as company join company.coupons As c WHERE company.id=:id AND c.type=:type")
	public List<Coupon> findCompanyCouponByType(int id, CouponType type);

	@Query("SELECT c from Company as company join company.coupons As c WHERE company.id=:id AND c.price=:price")
	public List<Coupon> findCompanyCouponByPrice(int id, double price);

	@Query("SELECT c from Company as company join company.coupons As c WHERE company.id=:companyid AND c.endDate=:endDate")
	public List<Coupon> findCompanyCouponByendDate(int companyid, Date endDate);

	@Query("SELECT c from Customer as customer join customer.coupons As c WHERE customer.id=:id")
	public List<Coupon> findCustomerCoupon(int id);

	@Query("SELECT c from Customer as customer join customer.coupons As c WHERE customer.id=:id AND c.type=:type")
	public List<Coupon> findCustomerCouponByType(int id, CouponType type);

	@Query("SELECT c from Customer as customer join customer.coupons As c WHERE customer.id=:id AND c.price=:price")
	public List<Coupon> findCustomerCouponByPrice(int id, double price);

	List<Coupon> findByEndDateBefore(Date date);

	@Query("SELECT c from Company as company join company.coupons As c WHERE company.id=:companyid AND c.id=:couponid")
	public Coupon findOneCoupon(int companyid, int couponid);

	@Query("SELECT c from Customer as customer join customer.coupons As c WHERE customer.id=:customerid AND c.id=:couponid")
	public Coupon findOneCustomerCoupon(int customerid, int couponid);
}
