/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skype.bot.item;

import com.skype.*;
import java.util.*;
import com.skype.bot.plugin.*;

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
        if (isBuyable()) {
            return TurnipPriceGenerator.getBuyPrice(500, 50, Date);
        } else {
            return TurnipPriceGenerator.getPrice(400, 200, Date);
        }
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
