/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.players;

import java.util.Comparator;

/**
 * Custom comparator for Player ids
 * @author Black
 */
public class PlayerComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        int a = o2.getId();
        int b = o1.getId();
        int cmp;
        if (a > b)
           cmp = +1;
        else if (a < b)
           cmp = -1;
        else
           cmp = 0;
        return cmp;
    }
}