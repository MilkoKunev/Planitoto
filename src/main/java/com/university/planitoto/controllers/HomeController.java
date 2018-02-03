package com.university.planitoto.controllers;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.university.planitoto.models.UserBean;

@Controller
@RequestMapping("/")
public class HomeController {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public HomeController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping
    public String helloFacebook(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
        populateUserDetailsFromFacebook(new UserBean());
        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        model.addAttribute("feed", feed);
        return "index";
    }
    
	 protected void populateUserDetailsFromFacebook(UserBean userForm) {
		 User user = facebook.userOperations().getUserProfile();
		 userForm.setEmail(user.getEmail());
		 userForm.setFirstName(user.getFirstName());
		 userForm.setLastName(user.getLastName());
		 userForm.setImage(user.getCover().getSource());
		 userForm.setProvider("facebook");
	 }

}
