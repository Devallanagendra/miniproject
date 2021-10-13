package com.petpeers.dao;

import java.util.List;

import com.petpeers.model.Pet;
import com.petpeers.model.User;

public interface SignupDao {

	List<User> getUserDetails();

	void saveUserDetails(User user);

	List<User> fetchUser(User user);

	List<Pet> getPetDetails();

	void savePetDetails(Pet pet);

	List<Pet> fetchPet(User user);

	void updatePet(Long userId, int id);

}
