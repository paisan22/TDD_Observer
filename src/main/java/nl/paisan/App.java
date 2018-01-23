package nl.paisan;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);

        subject.setState(11);
    }
}
