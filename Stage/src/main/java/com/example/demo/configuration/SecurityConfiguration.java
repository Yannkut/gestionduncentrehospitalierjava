package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private UserPrincipalDetailsService userPrincipalDetailsService;
    @Autowired
    private UserRepository userRepository;


    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService, UserRepository userRepository) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
        this.userRepository = userRepository;

        
    }

 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }
  
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
       // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      //  .and()
        //.addFilter(new JwtAuthenticationFilter(authenticationManager()))
       // .addFilter(new JwtAuthorizationFilter(authenticationManager(), this.userRepository))
        .authorizeRequests()
        
        .antMatchers("/").permitAll()
       
             
        
      //---------has Role Admin//________________
        .antMatchers("/admin/**").hasRole("ADMIN")
        
      //---------Patient//________________
        
        .antMatchers("/gestionpatient").hasRole("ADMIN")
        .antMatchers("/nouveauPatient").hasRole("ADMIN")
        .antMatchers("/getAllPatients").hasRole("ADMIN")
        .antMatchers("/getpat").hasRole("ADMIN")
        .antMatchers("/getPatient").hasRole("ADMIN")
        .antMatchers("/deletepat").hasRole("ADMIN")
        .antMatchers("/listpatientbyadminpdf").hasRole("ADMIN")
        
        //---------Secrétaire//________________
        .antMatchers("/gestionsecretaire").hasRole("ADMIN")
        .antMatchers("/nouveauSecretaire").hasRole("ADMIN")
        .antMatchers("/getAllSecretaire").hasRole("ADMIN")
        .antMatchers("/getsecr").hasRole("ADMIN")
        .antMatchers("/getSecretaire").hasRole("ADMIN")
        .antMatchers("/deletesecr").hasRole("ADMIN")
       
        //---------Actionnaire//________________
        .antMatchers("/gestionactionnaire").hasRole("ADMIN")
        .antMatchers("/nouveauActionnaire").hasRole("ADMIN")
        .antMatchers("/getAllActionnaires").hasRole("ADMIN")
        .antMatchers("/listactionnairepdf").hasRole("ADMIN")
        
        .antMatchers("/getact").hasRole("ADMIN")
        .antMatchers("/getActionnaire").hasRole("ADMIN")
        .antMatchers("/deleteact").hasRole("ADMIN")
        //---------Médecin//________________
        
        .antMatchers("/gestionmedecin").hasRole("ADMIN")
        .antMatchers("/nouveauMedecin").hasRole("ADMIN")
        .antMatchers("/getAllMedecins").hasRole("ADMIN")
        .antMatchers("/listmedecinpdf").hasRole("ADMIN")
        .antMatchers("/getmed").hasRole("ADMIN")
        .antMatchers("/getMedecin").hasRole("ADMIN")
        .antMatchers("/deletemed").hasRole("ADMIN")
        
        //---------Comptable//________________
        
        .antMatchers("/gestioncomptable").hasRole("ADMIN")
        .antMatchers("/nouveauComptable").hasRole("ADMIN")
        .antMatchers("/getAllComptables").hasRole("ADMIN")
        .antMatchers("/listcomptablepdf").hasRole("ADMIN")
        .antMatchers("/getcomp").hasRole("ADMIN")
        .antMatchers("/getComptable").hasRole("ADMIN")
        .antMatchers("/deletecomp").hasRole("ADMIN")
        
      //---------User//________________
        .antMatchers("/gestionuser").hasRole("ADMIN")
        .antMatchers("/nouveauUser").hasRole("ADMIN")
        .antMatchers("/getAllUsers").hasRole("ADMIN")
        .antMatchers("/listuserpdf").hasRole("ADMIN")
        .antMatchers("/getUser").hasRole("ADMIN")
        .antMatchers("/getuser").hasRole("ADMIN")
        .antMatchers("/deleteuser").hasRole("ADMIN")
        
        


        
      //---------has Role Secrétaire//________________
        .antMatchers("/secretaire/**").hasAnyRole("ADMIN","SECRETAIRE")
        
      //---------RDV//________________
        .antMatchers("/spgestionRendezvous").hasAnyRole("ADMIN","SECRETAIRE")
        .antMatchers("/spaffecterRDV").hasAnyRole("ADMIN","SECRETAIRE")
        .antMatchers("/spgetAllRDV").hasAnyRole("ADMIN","SECRETAIRE")
        .antMatchers("/spgetrdvous").hasAnyRole("ADMIN","SECRETAIRE")
        .antMatchers("/spgetrdv").hasAnyRole("ADMIN","SECRETAIRE")
        .antMatchers("/listrendezvouspdf").hasAnyRole("ADMIN","SECRETAIRE")
        .antMatchers("/spdeleterdv").hasAnyRole("ADMIN","SECRETAIRE")
        //---------Patient//________________
        .antMatchers("/spgestionPatient").hasAnyRole("ADMIN","SECRETAIRE")
        .antMatchers("/spnouveauPatient").hasAnyRole("ADMIN","SECRETAIRE")
        .antMatchers("/spgetAllPatients").hasAnyRole("ADMIN","SECRETAIRE")
        .antMatchers("/listpatientpdf").hasAnyRole("ADMIN","SECRETAIRE")
        .antMatchers("/spgetPatient").hasAnyRole("ADMIN","SECRETAIRE")
        .antMatchers("/spget").hasAnyRole("ADMIN","SECRETAIRE")
        .antMatchers("/spdelete").hasAnyRole("ADMIN","SECRETAIRE")
        
        
        
        //---------has Role Actionnaire//________________


        
        //---------has Role Médecin//________________
        .antMatchers("/medecin/**").hasAnyRole("ADMIN","MEDECIN")
      //---------Gestion RDV//________________
        
        .antMatchers("/mpgestionRDV").hasAnyRole("ADMIN","MEDECIN")
        .antMatchers("/mpnRDV").hasAnyRole("ADMIN","MEDECIN")
        .antMatchers("/mpRDV").hasAnyRole("ADMIN","MEDECIN")
        .antMatchers("/mpgetrdv").hasAnyRole("ADMIN","MEDECIN")
        .antMatchers("/mpGetRDV").hasAnyRole("ADMIN","MEDECIN")
        .antMatchers("/mdpdeleterdv").hasAnyRole("ADMIN","MEDECIN")
        .antMatchers("/listrdvmpdf").hasAnyRole("ADMIN","MEDECIN")

      //---------Gestion Consultation//________________
        .antMatchers("/NouvelleConsultation").hasAnyRole("ADMIN","MEDECIN")
        .antMatchers("/ListeConsultations").hasAnyRole("ADMIN","MEDECIN")
        .antMatchers("/mpdeletecons").hasAnyRole("ADMIN","MEDECIN")
        .antMatchers("/mpgetcons").hasAnyRole("ADMIN","MEDECIN")
        .antMatchers("/mpgetconsul").hasAnyRole("ADMIN","MEDECIN")
        .antMatchers("/listconsultationpdf").hasAnyRole("ADMIN","MEDECIN")
      //---------Traitement//________________
        .antMatchers("/mpnouveauTraitement").hasAnyRole("ADMIN","MEDECIN")
        .antMatchers("/ListeTraitements").hasAnyRole("ADMIN","MEDECIN")
       
        .antMatchers("/listtraitementpdf").hasAnyRole("ADMIN","MEDECIN")
        
        
        
      //---------has Role Comptable//________________
        .antMatchers("/comptable/**").hasAnyRole("ADMIN","COMPTABLE")
        
        .antMatchers("/nouvelleFacture").hasAnyRole("ADMIN","COMPTABLE")
        .antMatchers("/ListeFactures").hasAnyRole("ADMIN","COMPTABLE")
       
        //comptable 
        .antMatchers("/nouvelleFacture").hasAnyRole("ADMIN","COMPTABLE")
        //---------has Role Comptable//________________
       

        .and()
        .formLogin().permitAll()
        .loginPage("/login")
        
        .and()
        .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
        .and()
        
        .rememberMe().tokenValiditySeconds(600).key("YannKut!").rememberMeParameter("checkRememberMe");

}
       
     

    

  

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
}





 

 

