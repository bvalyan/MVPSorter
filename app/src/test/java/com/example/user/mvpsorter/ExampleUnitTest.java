package com.example.user.mvpsorter;

import com.example.user.mvpsorter.UI.MainPresenter;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void check_averaging_algorithm() {
        ArrayList<Integer> testNums = new ArrayList<>();
        testNums.add(15);
        testNums.add(10);
        testNums.add(100);
        int result = MainPresenter.sumArray(testNums);
        assertEquals(41, result);
    }

    @Test
    public void check_sorting_algorithm(){
        ArrayList<Integer> testNums = new ArrayList<>();
        testNums.add(10);
        testNums.add(1);
        testNums.add(85);
        testNums.add(23);
        testNums.add(4);
        testNums.add(329);

       ArrayList<Integer> testArray = MainPresenter.manualSort(testNums);   // Use our method to sort the array
       Integer [] test = testArray.toArray(new Integer[testArray.size()]);  // Convert the arraylist to an array

       Collections.sort(testNums); //Sort our array using java's libraries

       Integer [] actualValue = testNums.toArray(new Integer[testNums.size()]); //convert the java library sorted arraylist to an array

       Assert.assertArrayEquals(actualValue,test); //test for equality
    }


}