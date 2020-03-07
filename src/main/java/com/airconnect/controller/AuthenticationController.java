package com.airconnect.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.airconnect.user.model.UserProfile;
import com.airconnect.user.service.UserProfileService;



@Controller
@RequestMapping("/")
@SessionAttributes({"roles"})
public class AuthenticationController {
	
		
	     
	    @Autowired
	    UserProfileService userProfileService;
	     
	    @Autowired
	    MessageSource messageSource;
	 
	    @Autowired
	    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	     
	    @Autowired
	    AuthenticationTrustResolver authenticationTrustResolver;
	     
	 
	    /**
	     * This method will provide UserProfile list to views
	     */
	    @ModelAttribute("roles")
	    public List<UserProfile> initializeProfiles() {
	        return userProfileService.findAll();
	    }
	     
	    /**
	     * This method handles Access-Denied redirect.
	     */
	    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	    public String accessDeniedPage(ModelMap model) {
	        return "accessDenied";
	    }
	 
	    /**
	     * This method handles login GET requests.
	     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
	     */
	    @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginPage() {
	        if (isCurrentAuthenticationAnonymous()) {
	            return "login";
	        } else {
	            return "redirect:/dashboard";  
	        }
	    }
	 
	    /**
	     * This method handles logout requests.
	     * Toggle the handlers if you are RememberMe functionality is useless in your app.
	     */
	    @RequestMapping(value="/logout", method = RequestMethod.GET)
	    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	            //new SecurityContextLogoutHandler().logout(request, response, auth);
	            persistentTokenBasedRememberMeServices.logout(request, response, auth);
	            SecurityContextHolder.getContext().setAuthentication(null);
	        }
	        return "redirect:/login?logout";
	    }
	 
	    /**
	     * This method returns true if users is already authenticated [logged-in], else false.
	     */
	    private boolean isCurrentAuthenticationAnonymous() {
	        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        return authenticationTrustResolver.isAnonymous(authentication);
	    }
	    
}