/*
 * Copyright © 2013 EAzama <eazama001@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.skype.bot.plugin;

import java.util.*;
/*
 * Class to generate turnip prices based on the base price and current date and time
 */

public class TurnipPriceGenerator {

    public static int getPrice(int base, int range, GregorianCalendar time) {
        Random rand = new Random(time.get(Calendar.DAY_OF_YEAR)
                + time.get(Calendar.YEAR) * 1000);
        switch (rand.nextInt(6)) {
            case (0):
                System.out.print("wave ");
                return wavePrice(base, range, time);
            case (1):
                System.out.print("des ");
                return desPrice(base, range, time);
            case (2):
                System.out.print("asc ");
                return ascPrice(base, range, time);
            case (3):
                System.out.print("low ");
                return lowPeakPrice(base, range, time);
            case (4):
                System.out.print("high ");
                return highPeakPrice(base, range, time);
            default:
                System.out.print("rand ");
                return randPrice(base, range, time);
        }
    }

    public static int getBuyPrice(int base, int range, GregorianCalendar time) {
        Random rand = new Random(time.get(Calendar.DAY_OF_YEAR
                + time.get(Calendar.YEAR) * 1000));
        int spread = rand.nextInt(range);
        if (rand.nextBoolean()) {
            return base + spread;

        } else {
            return base - spread;
        }
    }

    public static int randPrice(int base, int range, GregorianCalendar time) {
        Random rand = new Random(time.get(Calendar.DAY_OF_YEAR)
                + time.get(Calendar.YEAR) * 1000
                + time.get(Calendar.HOUR_OF_DAY) * 10000000);
        int spread = rand.nextInt(range);
        if (rand.nextBoolean()) {
            return base + spread;
        } else {
            return base - spread;
        }
    }

    public static int wavePrice(int base, int range, GregorianCalendar time) {
        Random rand = new Random(time.get(Calendar.DAY_OF_YEAR)
                + time.get(Calendar.YEAR) * 1000
                + time.get(Calendar.HOUR_OF_DAY) * 10000000);
        int spread = (int) (Math.sin(Calendar.HOUR_OF_DAY) * (.85 + (1.1 - .85) * rand.nextDouble()) * range);
        return base + spread;
    }

    public static int desPrice(int base, int range, GregorianCalendar time) {
        Random rand = new Random(time.get(Calendar.DAY_OF_YEAR)
                + time.get(Calendar.YEAR) * 1000
                + time.get(Calendar.HOUR_OF_DAY) * 10000000);
        int spread = (int) (Math.sin(.13 * (Calendar.HOUR_OF_DAY + 12)) * (.85 + (1.1 - .85) * rand.nextDouble()) * range);
        return base + spread;
    }

    public static int ascPrice(int base, int range, GregorianCalendar time) {
        Random rand = new Random(time.get(Calendar.DAY_OF_YEAR)
                + time.get(Calendar.YEAR) * 1000
                + time.get(Calendar.HOUR_OF_DAY) * 10000000);
        int spread = (int) (Math.sin(.13 * (Calendar.HOUR_OF_DAY - 12)) * (.85 + (1.1 - .85) * rand.nextDouble()) * range);
        return base + spread;
    }

    public static int lowPeakPrice(int base, int range, GregorianCalendar time) {
        Random rand = new Random(time.get(Calendar.DAY_OF_YEAR)
                + time.get(Calendar.YEAR) * 1000
                + time.get(Calendar.HOUR_OF_DAY) * 10000000);
        int spread = (int) (Math.sin(.26 * (Calendar.HOUR_OF_DAY + 7)) * (.85 + (1.1 - .85) * rand.nextDouble()) * range);
        return base + spread;
    }

    public static int highPeakPrice(int base, int range, GregorianCalendar time) {
        Random rand = new Random(time.get(Calendar.DAY_OF_YEAR)
                + time.get(Calendar.YEAR) * 1000
                + time.get(Calendar.HOUR_OF_DAY) * 10000000);
        double fraction = Math.sin(.55*time.get(Calendar.HOUR_OF_DAY));
        System.out.print(fraction + " ");
        int spread = (int) (Math.sin(.55 * (time.get(Calendar.HOUR_OF_DAY)))*range);
        System.out.print(spread + " ");
        return base + spread;
    }
}
