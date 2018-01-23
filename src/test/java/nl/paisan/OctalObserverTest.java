package nl.paisan;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by paisanrietbroek on 23/01/2018.
 */
public class OctalObserverTest {

    private Subject subjectMock;
    private OctalObserver octalObserver;

    @Before
    public void setup() {
        this.subjectMock = mock(Subject.class);
        this.octalObserver = new OctalObserver(this.subjectMock);
    }

    @Test
    public void testObjectCreation() {

        // assert
        assertThat(octalObserver, isA(OctalObserver.class));
        verify(subjectMock, times(1)).attach(any(Observer.class));
    }

    @Test
    public void testUpdate() {

        // arrange
        when(subjectMock.getState()).thenReturn(11);

        // act
        String result = octalObserver.update();

        // assert
        assertThat(result, is("13"));

    }

}
