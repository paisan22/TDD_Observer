package nl.paisan;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by paisanrietbroek on 23/01/2018.
 */
public class SubjectTest {

    private Observer observerMock;

    private Subject subject;

    @Before
    public void setup() {
        this.subject = new Subject();
        this.observerMock = mock(Observer.class);
    }

    @Test
    public void testObjectCreation() {

        // assert
        assertThat(this.subject, isA(Subject.class));
    }

    @Test
    public void testGetState() {

        // act
        int result = this.subject.getState();

        // assert
        assertThat(result, is(0));
    }

    @Test
    public void testAttachObserver() {

        // act
        this.subject.attach(this.observerMock);

        // assert
        assertThat(subject.getObserverList().size(), is(1));
    }

    @Test
    public void testNotifyAllObservers() {

        // arrange
        Observer observer = spy(Observer.class);
        Observer observer1 = spy(Observer.class);

        this.subject.attach(observer);
        this.subject.attach(observer1);

        // act
        this.subject.notifyAllObservers();

        // assert
        verify(observer, times(1)).update();
        verify(observer1, times(1)).update();
    }

    @Test
    public void testSetState() {

        // arrange
        this.subject.attach(observerMock);

        // act
        this.subject.setState(3);

        // assert
        assertThat(this.subject.getState(), is(3));
        verify(this.observerMock, times(1)).update();
    }

}
