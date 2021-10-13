package com.petpeers.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petpeers.model.Pet;
import com.petpeers.model.User;

@Repository
public class SignupDaoImpl implements SignupDao {
	@Autowired
	SessionFactory sessionFactory;

	public void saveLoginDetails(User signup) {
		sessionFactory.openSession().save(signup);
		System.out.println("saved successfully...........");
	}

	public List<User> getUserDetails() {
		Query query = sessionFactory.openSession().createQuery("from Signup");
		List<User> sList = query.list();
		sList.forEach(q -> System.out.println(q));
		return sList;
	}

	public void saveUserDetails(User user) {
		try {
			sessionFactory.openSession().save(user);
			System.out.println("saved successfully...........");
		} catch (Exception e) {
			System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEE");
			System.out.println(e);
		}
	}

	public List<User> fetchUser(User user) {
		Query query1 = sessionFactory.openSession().getNamedQuery("findUserByUsername");
		query1.setParameter("userName", user.getUserName());
		List<User> list = query1.list();
		return list;
	}

	public List<Pet> getPetDetails() {
		Query query = sessionFactory.openSession().createQuery("from Pet");
		List<Pet> sList = query.list();
		sList.forEach(q -> System.out.println(q));
		return sList;
	}

	public void savePetDetails(Pet pet) {
		try {
			sessionFactory.openSession().save(pet);
			System.out.println("pet saved successfully...........");
		} catch (Exception e) {
			System.out.println("PPPPPPPPPPEEEEEEEEEEEEEEEEEEEEEEEEEE");
			System.out.println(e);
		}
	}

	public List<Pet> fetchPet(User user) {
		Query query1 = sessionFactory.openSession().createQuery("from Pet p where p.user = :id");
		query1.setParameter("id", user);
		List<Pet> list = query1.list();
		list.forEach(q -> System.out.println(q));
		return list;
	}

	public void updatePet(Long userId, int id) {
		Query query1 = sessionFactory.openSession().createQuery("update Pet set userId =:userId where id = :id");
		query1.setParameter("userId", userId);
		query1.setParameter("id", id);
		Query query2 = sessionFactory.openSession().createQuery("update Pet set status =:status where id = :id");
		query2.setParameter("status", "Sold");
		query2.setParameter("id", id);
		query1.executeUpdate();
		System.out.println("UUUUUUUUUUUUUUUUUUUUUUUUU");
		query2.executeUpdate();
		System.out.println("u2222222222222222222222222222222222222");
	}

}
