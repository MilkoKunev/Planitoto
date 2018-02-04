package com.university.planitoto.controllers;

import com.university.planitoto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoOperations mongoOperations;

    public HomeController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping
    public String helloFacebook(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
        populateUserDetailsFromFacebook();
        return "index";
    }
    
	 protected void populateUserDetailsFromFacebook() {
        //Get facebook profile
		 User user = facebook.userOperations().getUserProfile();
		 //Check if user is in Mongo
         //Update if userBean is returned from mongoDB, in case of new data
		 UserBean userBean = userRepository.findByFacebookId(user.getId());
         if(userBean != null) {
             mongoOperations.updateFirst(new Query().addCriteria(Criteria.where("facebookId").is(user.getId())),
                     new Update().set("firstName", user.getFirstName())
                                 .set("lastName", user.getLastName())
                                 .set("facebookId", user.getId()), UserBean.class);
         }
         else{
             userBean = new UserBean();
             userBean.setFirstName(user.getFirstName());
             userBean.setLastName(user.getLastName());
             userBean.setFacebookId(user.getId());
             userBean.setProvider("facebook");
             userRepository.save(userBean);
         }
	 }
}
