/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skype.bot.item;

import com.skype.*;
import java.util.*;

public class ItemTurnip extends ItemModule {

    @Override
    public void ItemFunction(ChatMessage msg) throws SkypeException {
        msg.getChat().send("You decide that it would be a bad idea to eat "
                + "your investment in the stalk market.\n"
                + "Besides, you don't have anything to cook this with.");
    }

    @Override
    public int getValue() {
        GregorianCalendar Date = new GregorianCalendar();
        Random TurnipRand = new Random(Date.get(Calendar.DAY_OF_YEAR) * Date.get(Calendar.YEAR));
        int val = (TurnipRand.nextInt(50) + 475);
        if(!isBuyable()){
            val += 500 * Math.pow(TurnipRand.nextDouble(), 8);
        }
        
        return val;
        
    }

    @Override
    public String getName() {
        return "Turnip";
    }

    @Override
    public boolean isBuyable() {
        if (new GregorianCalendar().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getShop() {
        return "TurnipShop";
    }
}
