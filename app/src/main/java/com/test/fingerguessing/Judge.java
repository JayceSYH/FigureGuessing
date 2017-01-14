package com.test.fingerguessing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/12/13.
 */
public class Judge {
    /**
     * determine which user win the game
     * @param list
     * @return
     */
    static String judge(List<String> list) {
        List<Integer> rock = new ArrayList<>();
        List<Integer> paper = new ArrayList<>();
        List<Integer> scissors = new ArrayList<>();

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).equals(PlayActivity.Rock)) {
                rock.add(i + 1);
            }
            if (list.get(i).equals(PlayActivity.Paper)) {
                paper.add(i + 1);
            }
            if (list.get(i).equals(PlayActivity.Scissors)) {
                scissors.add(i + 1);
            }
        }

        int r = rock.size() > 0 ? 1 : 0;
        int p = paper.size() > 0 ? 1 : 0;
        int s = scissors.size() > 0 ? 1 : 0;

        if (r + p + s == 2) {
            if (r > 0 && p > 0) {
                return lToString(paper);
            }
            else if (r >0 && s > 0) {
                return lToString(rock);
            }
            else {
                return lToString(scissors);
            }
        }
        else {
            return "";
        }
    }

    /**
     * convert list of no to string format
     * @param list
     * @return
     */
    static private String lToString(List<Integer> list) {
        if (list.size() == 0) {
            return "";
        }
        else {
            String ret = String.valueOf(list.get(0));
            for (int i = 1; i < list.size(); ++i) {
                if (ret.length() > 0) {
                    ret += ";" + list.get(i);
                }
                else {
                    ret += list.get(i);
                }
            }

            return ret;
        }
    }
}
