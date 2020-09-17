package com.indium.courses.controllers;

import com.indium.courses.models.User;
import com.indium.courses.repositories.CourseRepository;
import com.indium.courses.repositories.UserRepository;
import com.indium.courses.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private SecurityService securityService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/showReg")
    public String showRegistrationPage() {
        LOGGER.info("Inside showRegistrationPage()");
        return "login/registerUser";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user, ModelMap modelmap) {
        LOGGER.info("{} Inside register()", user.getEmail());
        Optional<User> foundUser= userRepository.findByEmail(user.getEmail());
        if(foundUser.isPresent()){
            LOGGER.error("User is already registered with email {} ",user.getEmail());
            modelmap.addAttribute("msg", "User with the given email id already exists.");
            return "login/registerUser";
        }
        LOGGER.info("Email Exists: "+user.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole("TRAINEE");
        userRepository.save(user);
        return "login/login";
    }

    @RequestMapping("/showLogin")
    public String showLoginPage() {
        LOGGER.info("Inside showLoginPage()");
        return "login/login";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap){
        LOGGER.info("{} Inside login()",email);
        Optional<User> foundUser=userRepository.findByEmail(email);
        if(!foundUser.isPresent()){
            modelMap.addAttribute("msg","Invalid username.");
        } else {
            LOGGER.info("Email Exists: "+email);
            try {
                boolean loginResponse = securityService.login(email, password);
                if (loginResponse) {
                    if("TRAINEE".equalsIgnoreCase(foundUser.get().getRole())) {
                        modelMap.addAttribute("msg", "Successfully logged in");
                        List courseList = courseRepository.findAll();
                        modelMap.addAttribute("courseList", courseList);
                        return "courses/course";
                    }
                } else {
                    LOGGER.info("User entered Invalid credentials email:{} and password:{}", email, password);
                    modelMap.addAttribute("msg", "Invalid username or password");
                }
            } catch(BadCredentialsException e) {
                modelMap.addAttribute("msg", "Invalid password");
            }
        }
        return "login/login";
    }

}
