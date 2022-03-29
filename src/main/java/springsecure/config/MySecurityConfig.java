package springsecure.config;

/*
 * @Author : Shahzadi Parveen
 * @Project Name : springsecure
 * @Created : 23-03-2022
 * @Mailto : shahzadicdac13@gmail.com
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
          http
                  .csrf().disable()//we are disabling it so that we can use post function
                  .authorizeRequests()
                  .antMatchers("/public/**").hasRole("USER")
                  .antMatchers("/users/**").hasRole("ADMIN")
                  .anyRequest()
                  .authenticated()
                  .and()
                  .formLogin(); //for form based authentication if you want to customized your form you can create your own page using thymeleaf
             //     .httpBasic();//for basic authentication

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication()
               .withUser("admin")
               .password(this.passwordEncoder().encode("password"))
               .roles("ADMIN");
       auth.inMemoryAuthentication()
               .withUser("user")
               .password(this.passwordEncoder().encode("pass"))
               .roles("USER");
    }


    //ROLE - High Level Overview -> NORMAL : READ
    //Authority - permission -> READ\
    //ADMIN - READ,WRITE,UPDATE

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(10);
    }
}
