/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.players;

import com.group9.players.PlayerJDBCTemplate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Black
 */

@Controller
public class PlayersController {
    
  
    @Autowired
    private PlayerJDBCTemplate playerJDBCTemplate;
    
    @RequestMapping(value="/players", method=RequestMethod.GET)
    public String viewPlayersPage (ModelMap map)
    {
        map.put("players", playerJDBCTemplate.listPlayers());
        
        return "listplayers";
    }  

}
