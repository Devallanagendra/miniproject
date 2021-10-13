package com.petpeers.service;

import java.util.List;

import com.petpeers.model.Pet;
import com.petpeers.model.User;

public interface SignupService {

	void saveUserDetails(User user);

	List<User> fetchUser(User user);

	List<User> getUserDetails();

	List<Pet> getPetDetails();

	void savePetDetails(Pet pet);

	List<Pet> fetchPet(User user);

	void updatePet(Long userId, int id);

}
