package web.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.model.RolesType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class SuccessUserHandler implements AuthenticationSuccessHandler {
    // Spring Security использует объект Authentication, пользователя авторизованной сессии.
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
//        roles.forEach(x -> System.out.println(x.toString())); //fixme
//        System.out.println("!!!!!!!!!!!!!!!!!!!!" + authentication.getDetails());
        if (roles.contains(RolesType.ROLE_ADMIN.toString())) {
            httpServletResponse.sendRedirect("/admin");
        } else if (roles.contains(RolesType.ROLE_USER.toString())) {
            httpServletResponse.sendRedirect("/user");
        }
    }
}
