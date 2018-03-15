# Peppy Calendar View
![](images/sample.gif)
----------


# Usage

1. Import the library into your project
  * Maven
    ```xml
    <dependency>
  	<groupId>com.snollidea</groupId>
  	<artifactId>peppy-calendarview</artifactId>
  	<version>0.1.0</version>
  	<type>pom</type>
    </dependency>
    ```
  * Gradle
    ```groovy
    compile 'com.snollidea:peppy-calendarview:0.1.0'
    ```
2. Add CalendarView in your xml layout
    ```xml
    <com.snollidea.peppycalendarview.CalendarView
        android:id="@+id/calendarView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:backgroundColor="#ffffff"
        app:textColor="#000000"
        app:textInsideCircleColor="#ffffff"
        app:weekDaysNamesColor="#9f9f9f"
        app:currentDayCircleColor="@color/colorGoogleGreen"
        app:selectedCircleColor="#c9c9c9"/>
    ```
3. Write the following code in your java file.
    ```java
    // Get a reference for the view.
    mCalendarView = findViewById(R.id.calendarView);
    
    // Set listeners
    mCalendarView.setOnMonthChangedListener(mOnMonthChangedListener);
    mCalendarView.setOnLoadEventsListener(mOnLoadEventsListener);
    mCalendarView.setOnDateSelectedListener(mOnDateSelectedListener);

    // Set range
    mCalendarView.setMinimumDate(minDateInMillis);
    mCalendarView.setMaximumDate(maxDateInMillis);

    // Set first day of week (default : Monday)
    mCalendarView.setFirstDayOfWeek(Calendar.MONDAY);
    ```

4. Provide the events for specifed month in `OnLoadEventsListener` callback.

License
----------

MIT License

Copyright (c) 2018 Anton X.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
