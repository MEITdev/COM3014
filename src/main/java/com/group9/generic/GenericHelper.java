package com.group9.generic;

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
}
