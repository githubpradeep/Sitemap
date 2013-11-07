import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class JdomCreator {
    private MyLogger logger;
    public  JdomCreator(String xml)
    {
        Document doc=null;
        logger=new MyLogger();

        SAXBuilder saxBuilder=new SAXBuilder();
        Reader stringReader=new StringReader(xml);
        try {
           doc=saxBuilder.build(stringReader);
            Element rootNode=doc.getRootElement();
            Element child=rootNode.getChild("url",rootNode.getNamespace())  ;
            List<Element> urls=rootNode.getChildren();
            for(Element element:urls)
            {
                 //System.out.println(element.getChildText("loc",rootNode.getNamespace()));
                logger.log(element.getChildText("loc",rootNode.getNamespace()));

            }

        } catch (JDOMException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
