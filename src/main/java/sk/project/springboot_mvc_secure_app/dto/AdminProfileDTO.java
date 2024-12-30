package sk.project.springboot_mvc_secure_app.dto;

import sk.project.springboot_mvc_secure_app.entity.Role;

public class AdminProfileDTO {

    private Long id;

    private String name;

    private String role;

//    private String originalRole;

//    public AdminProfileDTO(Long id, String name, String role, String originalRole) {
//        this.id = id;
//        this.name = name;
//        this.role = role;
//        this.originalRole = originalRole;
//    }


    public AdminProfileDTO(Long id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role.getRoleName();
//        this.originalRole = role.getRoleName();
    }

//    public boolean isChanged() {
//        return !this.role.equals(this.originalRole);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public String getOriginalRole() {
//        return originalRole;
//    }
//
//    public void setOriginalRole(String originalRole) {
//        this.originalRole = originalRole;
//    }

}
