package nl.paisan;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.mockito.Mockito.*;

/**
 * Created by paisanrietbroek on 23/01/2018.
 */
public class BinaryObserverTest {

    private Subject subjectMock;
    private BinaryObserver binaryObserver;

    @Before
    public void setup() {

        this.subjectMock = mock(Subject.class);
        this.binaryObserver = new BinaryObserver(this.subjectMock);

    }

    @Test
    public void testObjectCreation() {

        // arrange
        doNothing().when(this.subjectMock).attach(any(Observer.class));

        // assert
        assertThat(binaryObserver, isA(BinaryObserver.class));
        assertThat(binaryObserver, isA(Observer.class));

        verify(this.subjectMock, times(1)).attach(binaryObserver);
    }

    @Test
    public void testUpdate() {

        // arrange
        when(subjectMock.getState()).thenReturn(11);

        // act
        String result = binaryObserver.update();

        // assert
        assertThat(result, is("1011"));

    }
}
