package com.example.user.mvpsorter.UI;

import com.example.user.mvpsorter.Network.Networking;

import java.util.ArrayList;
import java.util.Collections;

public class MainPresenter implements FinishInterface{
    private final View view;
    private final ArrayList<String> list;

    public MainPresenter(View view) {
        this.list = new ArrayList<String>();
        this.view = view;
    }


    public void retrieveNumbers() { //get data from our model
        Networking.getData(this);
    }

    @Override
    public void onFinished(ArrayList<Integer> netArrayList) { // our view updates after information has been obtained from our model
        ArrayList<Integer> sortedNums = sortArray(netArrayList);
        int sum = sumArray(sortedNums);
        view.updateRecyclerView(sortedNums);
        view.updateSum(sum);
    }

    public static int sumArray(ArrayList<Integer> sortedNums) { // get the sum of all values in the array
        int sum = 0;
        for(int i = 0; i < sortedNums.size(); i++){
            sum += sortedNums.get(i);
        }
        sum = sum/sortedNums.size();

        return sum;
    }


    private ArrayList<Integer> sortArray(ArrayList<Integer> numbers) {
         manualSort(numbers);
         return numbers;
    }

    public static ArrayList<Integer> manualSort(ArrayList<Integer> numbers) { //sort the values using an implementation of insert sort
        int temp;
        for (int i = 1; i < numbers.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (numbers.get(j) < numbers.get(j - 1)) {
                    temp = numbers.get(j);
                    numbers.set(j, numbers.get(j - 1));
                    numbers.set(j - 1, temp);
                }
            }
        }
        return numbers;
    }

    @Override
    public void onFailure(Throwable t) { //tell our view to display an error message if there is a network error
        view.displayErrorToast();
    }

    public interface View{
        void updateRecyclerView(ArrayList<Integer> list);
        void updateSum(int sum);
        void displayErrorToast();
    }


}
