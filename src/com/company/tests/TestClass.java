package com.company.tests;

import com.company.task.FrequentString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;


/**
 * Created by yasina on 20.02.16.
 */
public class TestClass {


    @Test
    public void test1(){
        List<String> words = new ArrayList<String>(){{
            add("num2");
            add("num2");
            add("num2");
            add("num1");
            add("num2");
            add("num1");
            add("num2");
            add("num3");
            add("num2");
            add("num4");
            add("num4");

            add("num5");
            add("num5");
            add("num2");
            add("num1");
            add("num7");
            add("num5");
            add("num8");
            add("num3");
            add("num2");
            add("num10");
            add("num3");

            add("num6");
            add("num6");
            add("num7");
            add("num7");
            add("num5");
            add("num8");
            add("num3");
            add("num9");
            add("num10");
            add("num3");
        }
        };

        FrequentString taskSolver = new FrequentString(words.iterator());
        List<String> frequentWords = taskSolver.getMostFrequentElements(10);

        Assert.assertTrue("Most frequent words is num2", "num2".equals(frequentWords.get(0)));
        Assert.assertTrue("Second frequent words is num3", "num3".equals(frequentWords.get(1)));
        Assert.assertTrue("3d frequent words is num5", "num5".equals(frequentWords.get(2)));
        Assert.assertTrue("4th frequent words is num7", "num7".equals(frequentWords.get(3)));
        Assert.assertTrue("5th frequent words is num1", "num1".equals(frequentWords.get(4)));

        Assert.assertTrue("6th frequent words is num8", "num8".equals(frequentWords.get(5)));
        Assert.assertTrue("7th frequent words is num10", "num10".equals(frequentWords.get(6)));
        Assert.assertTrue("8th frequent words is num6", "num6".equals(frequentWords.get(7)));
        Assert.assertTrue("9th frequent words is num4", "num4".equals(frequentWords.get(8)));
        Assert.assertTrue("10th frequent words is num9", "num9".equals(frequentWords.get(9)));
    }
}
