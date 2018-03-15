package com.snollidea.peppycalendarview;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.snollidea.peppycalendarview.event.CalendarEvent;
import com.snollidea.peppycalendarview.format.CalendarMonthNameFormatter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BasicActivity extends AppCompatActivity implements OnMonthChangedListener,
        OnDateSelectedListener, OnLoadEventsListener {

    private CalendarMonthNameFormatter mFormatter = new CalendarMonthNameFormatter();

    private EventsAdapter mEventsAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.calendarView)
    CalendarView mCalendarView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        ButterKnife.bind(this);

        mEventsAdapter = new EventsAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mEventsAdapter);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setBackgroundDrawable(
                    new ColorDrawable(mCalendarView.getBackgroundColor()));
        }

        mCalendarView.setOnMonthChangedListener(this);
        mCalendarView.setOnLoadEventsListener(this);
        mCalendarView.setOnDateSelectedListener(this);

        Calendar calendar = Calendar.getInstance();

        calendar.set(2015, Calendar.JANUARY, 1);
        mCalendarView.setMinimumDate(calendar.getTimeInMillis());

        calendar.set(2019, Calendar.OCTOBER, 1);
        mCalendarView.setMaximumDate(calendar.getTimeInMillis());

//        mCalendarView.setFirstDayOfWeek(Calendar.MONDAY);
    }

    @Override
    public void onMonthChanged(Calendar monthCalendar) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(mFormatter.format(monthCalendar));
        }
    }

    @Override
    public void onDateSelected(Calendar dayCalendar, @Nullable List<CalendarEvent> events) {
        mEventsAdapter.clearList();

        if (events == null) {
            return;
        }

        for (CalendarEvent event : events) {
            if (event instanceof MyEvent) {
                mEventsAdapter.addEvent((MyEvent) event);
            }
        }
    }


    @Override
    public List<? extends CalendarEvent> onLoadEvents(int year, int month) {
        // Fill by random events
        List<MyEvent> events = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);

        int[] daysNumbs = getRandomNumbs(1, calendar.getActualMaximum(Calendar.DAY_OF_MONTH),
                10); // Events count

        for (int dayNumb : daysNumbs) {
            calendar.set(Calendar.DAY_OF_MONTH, dayNumb);
            MyEvent event = new MyEvent("Example event", calendar.getTimeInMillis(), getRandomColor());
            events.add(event);
        }

        return events;
    }

    private int[] getRandomNumbs(int start, int end, int count) {
        int[] numbs = new int[count];

        for (int i = 0; i < numbs.length; i++) {
            int numb = start + (int) (Math.random() * end);
            numbs[i] = numb;
        }

        return numbs;
    }

    private int getRandomColor() {
        Resources resources = getResources();

        int rand = (int) (Math.random() * 4);
        switch (rand) {
            case 0:
                return resources.getColor(R.color.colorGoogleRed);
            case 1:
                return resources.getColor(R.color.colorGoogleYellow);
            case 2:
                return resources.getColor(R.color.colorGoogleBlue);
            case 3:
                return resources.getColor(R.color.colorGoogleGreen);
        }

        return 0x000000;
    }
}
