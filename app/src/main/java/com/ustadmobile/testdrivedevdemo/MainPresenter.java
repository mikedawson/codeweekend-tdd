package com.ustadmobile.testdrivedevdemo;

import java.util.Calendar;

public class MainPresenter {

    MainView view = null;

    public static final int ADULT_THRESHOLD = 13;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void handleClickNext(int day, int month, int year) {
        Calendar now = Calendar.getInstance();
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(year, month, day);
        int age = now.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        if(dateOfBirth.get(Calendar.DAY_OF_YEAR) > now.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        if(age > ADULT_THRESHOLD) {
            view.showAdultScreen();
        }else {
            view.showChildScreen();
        }

    }
}
