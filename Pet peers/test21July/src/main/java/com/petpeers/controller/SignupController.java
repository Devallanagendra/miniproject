package com.petpeers.controller;

import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petpeers.model.Pet;
import com.petpeers.model.User;
import com.petpeers.service.SignupService;

@Controller

public class SignupController {
	@Autowired
	SignupService svrIntf;

	@RequestMapping("/toLogin")
	public ModelAndView toLogin(@ModelAttribute("user") User user, HttpSession httpSession) {
		httpSession.invalidate();
		return new ModelAndView("loginPage");
	}

	@RequestMapping("/toMyPet")
	public ModelAndView toMyPet(HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");

		List<Pet> pList = svrIntf.fetchPet(user);
		System.out.println(pList);
		return new ModelAndView("MyPet", "list", pList);
	}

	@RequestMapping("/home")
	public ModelAndView home() {
		List<Pet> listAll = svrIntf.getPetDetails();
		return new ModelAndView("homePage", "pets", listAll);
	}

	@RequestMapping("/toAddpet")
	public ModelAndView toAddPet(@ModelAttribute("pet") Pet pet) {

		return new ModelAndView("addPetPage");
	}

	@RequestMapping("/toUserReg")
	public ModelAndView toUserReg(@ModelAttribute("user") User user) {
		return new ModelAndView("registrationPage");
	}

	@RequestMapping("/saveUser")
	public ModelAndView saveUser(@ModelAttribute("user") User user, ModelMap model) {
		if (user.getUserName() != "" && user.getConfirmPassword() != "" && user.getUserPassword() != "") {
			List<User> uList = svrIntf.fetchUser(user);
			if (uList.size() == 0) {
				if (user.getConfirmPassword().equals(user.getUserPassword())) {
					String BasicBase64format = Base64.getEncoder().encodeToString(user.getUserPassword().getBytes());
					System.out.println(BasicBase64format);
					user.setUserPassword(BasicBase64format);
					svrIntf.saveUserDetails(user);
					Object[] data = new Object[3];
					data[0] = "User Created successfully";
					data[1] = uList;
					return new ModelAndView("loginPage", "data", data);
				} else {
					model.addAttribute("error_message", "Password and Confirm password doesnt match");
					return new ModelAndView("registrationPage");
				}
			} else {
				model.addAttribute("error_message", "User Name already in use. Please select a different User Name");
				return new ModelAndView("registrationPage");
			}
		} else {
			model.addAttribute("error_message", "All fields are mandatory");
			return new ModelAndView("registrationPage");
		}

	}

	@RequestMapping("/savePet")
	public ModelAndView savePet(@ModelAttribute("pet") Pet pet, ModelMap model) {
		if (pet.getName() != "" && pet.getPlace() != "" && pet.getAge() != 0) {
			int age = pet.getAge();
			if (age > 0 && age <= 98) {
				svrIntf.savePetDetails(pet);
				return new ModelAndView("redirect:/home");
			} else {
				model.addAttribute("error_message", "Age filed should be numeric between 0 and 99");
				return new ModelAndView("addPetPage");
			}

		} else {
			model.addAttribute("error_message", "All Fields are mandatory");
			return new ModelAndView("addPetPage");
		}

	}

	@RequestMapping("/buyPet/{id}")
	public ModelAndView toMyPetSave(HttpSession httpSession, @PathVariable("id") int id) {
		User user = (User) httpSession.getAttribute("user");
		svrIntf.updatePet(user.getUserId(), id);

		return new ModelAndView("redirect:/toMyPet");
	}

	@RequestMapping("/authenticateUser")
	public ModelAndView authenticateUser(@ModelAttribute("user") User user, ModelMap model, HttpSession httpSession) {
		List<User> uList = svrIntf.fetchUser(user);
		List<Pet> listAll = svrIntf.getPetDetails();

		if (user.getUserPassword() != "" && user.getUserName() != "") {
			if (uList.size() == 0) {
				model.addAttribute("errMsg", "Please try with different User Name");
				return new ModelAndView("loginPage");

			} else {
				String encoded = uList.get(0).getUserPassword();
				System.out.println(encoded);
				byte[] actualByte = Base64.getDecoder().decode(encoded);
				String actualString = new String(actualByte);
				System.out.println("DDDDDDDDDDDDDDDDDddd");
				System.out.println(actualString);
				if (actualString.equals(user.getUserPassword())) {
					System.out.println(uList);
					httpSession.setAttribute("user", uList.get(0));
					return new ModelAndView("homePage", "pets", listAll);
				}

				else {
					model.addAttribute("errMsg", "Password is invalid");
					return new ModelAndView("loginPage");
				}
			}
		} else {
			model.addAttribute("errMsg", "Please fill these fields");
			return new ModelAndView("loginPage");
		}

	}

}
