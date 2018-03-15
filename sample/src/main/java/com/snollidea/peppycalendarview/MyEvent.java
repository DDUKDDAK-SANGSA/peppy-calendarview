package com.snollidea.peppycalendarview;

import com.snollidea.peppycalendarview.event.CalendarEvent;

public class MyEvent extends CalendarEvent {

    private String mTitle;

    MyEvent(String title, long startTimeInMillis, int indicatorColor) {
        super(startTimeInMillis, indicatorColor);
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }
}
