package com.sut.se.g02;

import lombok.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;
import java.util.Date;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.sql.Timestamp;
import javax.persistence.*;

import com.sut.se.g02.repository.*;
import com.sut.se.g02.entity.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderTests {


	@Autowired
	private OrderMedicineRepository orderMedicineRepository;
	@Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private CompanyRepository companyRepository;


	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	@Test
	public void FinishOrder() {
		OrderMedicine orderMedicine = new OrderMedicine();
		Medicine m = this.medicineRepository.findByMedicineId(1L);
		Company c = this.companyRepository.findByCompanyId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);

		orderMedicine.setMedicine(m);
		orderMedicine.setCompany(c);
		orderMedicine.setNurse(n);
		
		orderMedicine.setNote("กะป๋อง123-456");
		orderMedicine.setNumber(10);


		try {
			entityManager.persist(orderMedicine);
			entityManager.flush();
			//fail("Should not pass to this line");
			System.out.println();
			System.out.println("----------> Finish  Compile Order <--------------------");
			//System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);

		}

	}
	@Test
	public void CannotNullNoteOrder() {
		OrderMedicine orderMedicine = new OrderMedicine();
		
		Medicine m = this.medicineRepository.findByMedicineId(1L);
		Company c = this.companyRepository.findByCompanyId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);
		orderMedicine.setMedicine(m);
		orderMedicine.setCompany(c);
		orderMedicine.setNurse(n);
		
		orderMedicine.setNote(null);
		orderMedicine.setNumber(10);


		try {
			entityManager.persist(orderMedicine);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------> Notnull Note<--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}

	}

		@Test
	public void CannotNullMedicine() {
		OrderMedicine orderMedicine = new OrderMedicine();
		
		//Medicine m = this.medicineRepository.findByMedicineId(1L);
		Company c = this.companyRepository.findByCompanyId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);
		orderMedicine.setMedicine(null);
		orderMedicine.setCompany(c);
		orderMedicine.setNurse(n);
		
		orderMedicine.setNote("123654");
		orderMedicine.setNumber(10);


		try {
			entityManager.persist(orderMedicine);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------> Notnull Medicine<--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}

	}

		@Test
	public void CannotNullCompany() {
		OrderMedicine orderMedicine = new OrderMedicine();
		
		Medicine m = this.medicineRepository.findByMedicineId(1L);
		//Company c = this.companyRepository.findByCompanyId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);
		orderMedicine.setMedicine(m);
		orderMedicine.setCompany(null);
		orderMedicine.setNurse(n);
		
		orderMedicine.setNote("123654");
		orderMedicine.setNumber(10);

		try {
			entityManager.persist(orderMedicine);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------> Notnull Company<--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}

	}

		@Test
	public void CannotNullNurse() {
		OrderMedicine orderMedicine = new OrderMedicine();
		
		Medicine m = this.medicineRepository.findByMedicineId(1L);
		Company c = this.companyRepository.findByCompanyId(1L);
		//Nurse n = this.nurseRepository.findByNurseId(1L);
		orderMedicine.setMedicine(m);
		orderMedicine.setCompany(c);
		orderMedicine.setNurse(null);
		
		orderMedicine.setNote("123654");
		orderMedicine.setNumber(10);


		try {
			entityManager.persist(orderMedicine);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------> Notnull Nurse<--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}

	}

	@Test
	public void CannotNullNumOrder() {
		OrderMedicine orderMedicine = new OrderMedicine();

		Medicine m = this.medicineRepository.findByMedicineId(1L);
		Company c = this.companyRepository.findByCompanyId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);
		orderMedicine.setMedicine(m);
		orderMedicine.setCompany(c);
		orderMedicine.setNurse(n);
		
		orderMedicine.setNote("123654");
		orderMedicine.setNumber(null);



		try {
			entityManager.persist(orderMedicine);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------> Notnull Num<--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}

	}
	@Test
	public void testPatternNoteOrder() {
		OrderMedicine orderMedicine = new OrderMedicine();
		
		Medicine m = this.medicineRepository.findByMedicineId(1L);
		Company c = this.companyRepository.findByCompanyId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);
		orderMedicine.setMedicine(m);
		orderMedicine.setCompany(c);
		orderMedicine.setNurse(n);
		
		orderMedicine.setNote("null");
		orderMedicine.setNumber(10);


		try {
			entityManager.persist(orderMedicine);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------> Comment Pattern Order <--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
	}
	@Test
	public void testSizeOrder() {
		OrderMedicine orderMedicine = new OrderMedicine();
		
		Medicine m = this.medicineRepository.findByMedicineId(1L);
		Company c = this.companyRepository.findByCompanyId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);
		orderMedicine.setMedicine(m);
		orderMedicine.setCompany(c);
		orderMedicine.setNurse(n);
		
		orderMedicine.setNote("11111111111111111111111111111111111111111111111111111111111");
		orderMedicine.setNumber(10);


		try {
			entityManager.persist(orderMedicine);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------> Comment Sizelong Order<--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
	}
}