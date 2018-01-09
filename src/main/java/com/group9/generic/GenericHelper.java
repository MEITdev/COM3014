package com.group9.generic;

import com.group9.config.games.GameController;
import com.group9.config.players.Player;
import com.group9.exceptions.RoleNotRecognised;
import com.group9.exceptions.UserNotFoundException;
import com.group9.login.User;
import com.group9.login.UserJDBCTemplate;
import com.group9.login.UserRole;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.ui.ModelMap;



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
    
    public static int calculateCost(int currentLevel){
        return (int)(((float)(currentLevel)*0.3)*Registry.upgradeCost);
    
    }
    
    public static boolean isPlayerInList(ArrayList<Player> players, Player playerToFind){
            
            
            for(Player p:players){
                if(p.getId() == playerToFind.getId()){
                    return true;
                }
            }
            return false;
            
    }
    
    public static boolean isAdmin(Set<UserRole> role){
        for(UserRole r : role){
            if (r == UserRole.ADMIN){
                return true;
            }
        }
        return false;
    }
    public static boolean isPremium(Set<UserRole> role){
        for(UserRole r : role){
            if (r == UserRole.PREMIUM){
                return true;
            }
        }
        return false;
    }
    
    
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
    