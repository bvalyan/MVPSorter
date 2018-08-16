package com.example.user.mvpsorter.UI;

import java.util.ArrayList;

public interface FinishInterface {
        void onFinished(ArrayList<Integer> netArrayList);
        void onFailure(Throwable t);
}
