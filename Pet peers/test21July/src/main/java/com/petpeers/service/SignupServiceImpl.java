package com.petpeers.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petpeers.dao.SignupDao;
import com.petpeers.model.Pet;
import com.petpeers.model.User;

@Service
@Transactional
public class SignupServiceImpl implements SignupService {
	@Autowired
	SignupDao signupDao;

	public List<User> getUserDetails() {
		return signupDao.getUserDetails();
	}

	public void saveUserDetails(User user) {
		signupDao.saveUserDetails(user);
	}

	public List<User> fetchUser(User user) {
		return signupDao.fetchUser(user);

	}

	public List<Pet> getPetDetails() {
		return signupDao.getPetDetails();
	}

	public void savePetDetails(Pet pet) {
		signupDao.savePetDetails(pet);
	}

	public List<Pet> fetchPet(User user) {
		return signupDao.fetchPet(user);
	}

	public void updatePet(Long userId, int id) {
		signupDao.updatePet(userId, id);
	}

}
