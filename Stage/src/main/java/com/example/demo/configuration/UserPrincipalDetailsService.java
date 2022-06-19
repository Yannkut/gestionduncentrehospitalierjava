package com.example.demo.configuration;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserRepository userRepository;
   

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
       
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        if(user!=null) {
              
        return userPrincipal;
    }
        	 throw  new UsernameNotFoundException ("Could not find user with username "+ username);	
        }
    
    
    


}