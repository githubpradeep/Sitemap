/**
 * Created with IntelliJ IDEA.
 * User: pradeep1
 * Date: 11/6/13
 * Time: 1:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class Url {
    private String loc;
    public String getLoc()
    {
        return loc;
    }
    public void setLoc(String loc)
    {
        this.loc=loc;
    }
    @Override
    public String toString()
    {
        return loc;
    }
}
