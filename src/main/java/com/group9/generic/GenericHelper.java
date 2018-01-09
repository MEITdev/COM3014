package com.group9.generic;

import com.group9.players.Player;
import com.group9.exceptions.RoleNotRecognised;
import com.group9.exceptions.UserNotFoundException;
import com.group9.login.User;
import com.group9.login.UserJDBCTemplate;
import com.group9.login.UserRole;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.ui.ModelMap;



public class GenericHelper {
    /**
     * Converts role enum to string
     * @param role
     * @return 
     */
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
    
    
    /**
     * Converts string to role enum
     * @param role
     * @return
     * @throws RoleNotRecognised 
     */
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
    /**
     * Calculates cost for an upgrade of player ability
     * @param currentLevel
     * @return 
     */
    public static int calculateCost(int currentLevel){
        return (int)(((float)(currentLevel)*0.3)*Registry.upgradeCost);
    
    }
    /**
     * Returns true or false based on if player is in this list
     * @param players
     * @param playerToFind
     * @return 
     */
    public static boolean isPlayerInList(ArrayList<Player> players, Player playerToFind){
            
            
            for(Player p:players){
                if(p.getId() == playerToFind.getId()){
                    return true;
                }
            }
            return false;
            
    }
    /**
     * Check if one of the user roles is an admin role
     * @param role
     * @return 
     */
    public static boolean isAdmin(Set<UserRole> role){
        for(UserRole r : role){
            if (r == UserRole.ADMIN){
                return true;
            }
        }
        return false;
    }
    /**
     * Check if one of the user roles is a Premium role
     * @param role
     * @return 
     */
    public static boolean isPremium(Set<UserRole> role){
        for(UserRole r : role){
            if (r == UserRole.PREMIUM){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Enables to display user information in a side bar
     * @param map
     * @param principal
     * @param userJDBCTemplate 
     */
    public static void handleUserInfo(ModelMap map, Principal principal, UserJDBCTemplate userJDBCTemplate){
        if( principal != null) {
            try {
                User u = userJDBCTemplate.getUser(principal.getName());
                map.addAttribute("isAdmin", (GenericHelper.isAdmin(u.getRoles())));
                map.addAttribute("userbudget", u.getBudget());
                map.addAttribute("principal", principal);
            } catch (UserNotFoundException ex) {
                Logger.getLogger(GenericHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }
}
    