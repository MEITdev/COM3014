package com.group9.generic;

import com.group9.exceptions.RoleNotRecognised;
import com.group9.login.UserRole;



/**
 *
 * @author Black
 */
public class GenericHelper {
    public static String roleToString(UserRole role){
        if(null != role)switch (role) {
            case ADMIN:
                return "ROLE_ADMIN";
            case USER:
                return "ROLE_USER";
            case PREMIUM:
                return "ROLE_PREMIUM";
            default:
                break;
        }
        return "";
    }
    
    
    
    public static UserRole stringToRole(String role) throws RoleNotRecognised{
        if(null != role)switch (role) {
            case "ROLE_ADMIN":
                return UserRole.ADMIN;
            case "ROLE_USER":
                return UserRole.USER;
            case "ROLE_PREMIUM":
                return UserRole.PREMIUM;
            default:
                break;
        }
        throw new RoleNotRecognised("Role "+role+" not recognised");
    
    }
}
