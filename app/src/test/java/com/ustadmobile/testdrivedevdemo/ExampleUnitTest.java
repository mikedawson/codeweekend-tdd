package com.ustadmobile.testdrivedevdemo;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void givenUserIsChild_whenHandleClickNextCalled_thenShouldGoToChildScreen() {
        MainView view = mock(MainView.class);

        MainPresenter presenter = new MainPresenter(view);

        presenter.handleClickNext(1, 2, 2015);

        verify(view).showChildScreen();
    }

    @Test
    public void givenUserIsAdult_whenHandleClickNextCalled_thenShouldGoToAdultScreen() {
        MainView view = mock(MainView.class);

        MainPresenter presenter = new MainPresenter(view);

        presenter.handleClickNext(1, 2, 1995);

        verify(view).showAdultScreen();
    }


}