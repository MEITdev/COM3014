
package com.group9.generic;



/**
 * Common registry used for often changed variables that are static thougout the application
 */

public class Registry {
    public static String[] publicSites = {"/", "/login", "/resources/**", "/register"};
    public static String[] adminSites = {"/admin/**", "/player/*/update"};

    public static int startingBudget = 1000000;
    public static int upgradeCost = 5000;
    public static int lootBoxPrice = 3500;
}
