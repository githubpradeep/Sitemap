import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep1
 * Date: 11/6/13
 * Time: 12:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class parser1 {
    static List<String> zipList=new ArrayList<String>();
    static MyLogger logger = new MyLogger();
    public static void parseUrl(String url)
    {
        Document doc= null;
        try
        {
            doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();

            Elements links = doc.select("loc");
            for (Element link : links)
            {

                zipList.add(link.text());
            }
        } catch (IOException e)
        {
           System.err.println(e);
        }

       for(String urlGz:zipList)
        {
            parseUrl1(urlGz);
        }

    }
    public static void parseUrl1(String url)
    {
        try {
            URLConnection connection = new URL(url).openConnection();
            String xml = "";
            BufferedReader in = null;
            connection.setReadTimeout(10000);
                in = new BufferedReader(new InputStreamReader(new GZIPInputStream(connection.getInputStream())));
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                xml+=inputLine;
            }
            JdomCreator jdomCreator=new JdomCreator(xml);
            in.close();


           // System.exit(0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }




    }
    public static void main(String []args)
    {
         parseUrl("http://www.flipkart.com/sitemap/sitemap_index.xml");
    }
}
