package lib.view.converter.user;

import com.nrslib.domain.model.user.UserRole;

public class UserRoleConverter {
    public UserRole convert(String roleId) {
        switch (roleId) {
            case "admin": return UserRole.ADMIN;
            case "member": return UserRole.MEMBER;
            default: throw new RuntimeException();
        }
    }

    public String convert(UserRole role) {
        switch (role) {
            case ADMIN: return "admin";
            case MEMBER: return "member";
            default: throw new RuntimeException();
        }
    }
}
