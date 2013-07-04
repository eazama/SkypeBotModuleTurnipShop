/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skype.bot.plugin;


import com.skype.bot.SkypeBot;
import com.skype.bot.event.*;


public class TurnipShopPlugin implements SkypeBotPlugin {

    @Override
    public void Init() {
        SkypeBot.addEventModule(new EventShop("TurnipShop", "$", 1.0));
    }

    @Override
    public String getName() {
        return "TurnipShop";
    }

}
