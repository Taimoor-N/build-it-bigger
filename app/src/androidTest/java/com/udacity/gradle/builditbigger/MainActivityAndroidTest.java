package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.util.Log;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Instrumented tests, which will execute on an Android device
 */
@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityAndroidTest {

    private static final String LOG_TAG = MainActivityAndroidTest.class.getSimpleName();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testEndpointsAsyncTaskResultNotNull() {
        // Context of the app under test
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        MainActivity.EndpointsAsyncTask endpointAsyncTask = new MainActivity.EndpointsAsyncTask();
        assertNotNull(endpointAsyncTask.execute(appContext));
    }

    @Test
    public void testEndpointsAsyncTaskReturnsNonEmptyString() {
        // Context of the app under test
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        MainActivity.EndpointsAsyncTask endpointAsyncTask = new MainActivity.EndpointsAsyncTask();
        assertNull(endpointAsyncTask.getRetrievedJoke());
        try {
            endpointAsyncTask.execute(appContext).get();  // get() will wait until execution ends
        } catch (Exception e) {
            Log.e(LOG_TAG, Objects.requireNonNull(e.getMessage()));
        }
        assertTrue(endpointAsyncTask.getRetrievedJoke().length() > 0);
    }

}