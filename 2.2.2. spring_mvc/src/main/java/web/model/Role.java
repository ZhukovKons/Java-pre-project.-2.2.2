package web.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
    private Long id;
    private RolesType role;

    public Role(Long id, RolesType role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolesType getRole() {
        return role;
    }

    public void setRole(RolesType role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role.toString();
    }
}
