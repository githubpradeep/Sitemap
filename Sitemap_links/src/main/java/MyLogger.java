import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: vivek
 * Date: 10/23/13
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyLogger
{
    private Logger logger = Logger.getLogger(MyLogger.class);
    public void log(String message)
    {
        logger.info(message);
    }
}
