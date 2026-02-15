package com.estoque.realcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdutosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProdutosApplication.class, args);
    }
}

Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2026-02-15T09:13:40.901-03:00 ERROR 8208 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

Parameter 1 of constructor in com.estoque.realcar.security.JwtAuthenticationFilter required a single bean, but 2 were found:
	- customUserDetailsService: defined in file [C:\Users\Athay\dev\Estoque\Estoque\target\classes\com\estoque\realcar\security\CustomUserDetailsService.class]
	- userDetailsServiceImpl: defined in file [C:\Users\Athay\dev\Estoque\Estoque\target\classes\com\estoque\realcar\security\UserDetailsServiceImpl.class]


Action:

Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed


package com.estoque.realcar.security;

import com.estoque.realcar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        var user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuário não encontrado"));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}

2026-02-15T11:21:39.197-03:00 DEBUG 17804 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Failed to complete request: org.springframework.security.authentication.BadCredentialsException: Usuário inexistente ou senha inválida
2026-02-15T11:21:39.224-03:00 DEBUG 17804 --- [nio-8080-exec-1] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController#error(HttpServletRequest)





