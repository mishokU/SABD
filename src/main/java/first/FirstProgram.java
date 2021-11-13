package first;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class FirstProgram {

    public Data result;
    public List<XmlArticle> articles;
    public CesarShift cesarShift;

    public void init() throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XmlHandler xmlHandler = new XmlHandler();
        saxParser.parse("src/main/java/first/test.xml", xmlHandler);

        result = xmlHandler.getWebsite();
        articles = result.getArticleList();
        cesarShift = new CesarShift();

        System.out.println();

        show();
        encrypt();
        show();
        decrypt();
        show();
    }

    public void encrypt(){
        for(XmlArticle article : articles){
            article.setTitle(cesarShift.encrypt(article.getTitle()));
            article.setContent(cesarShift.encrypt(article.getContent()));
        }
    }

    public void decrypt(){
        for(XmlArticle article : articles){
            article.setTitle(cesarShift.decrypt(article.getTitle()));
            article.setContent(cesarShift.decrypt(article.getContent()));
        }
    }

    public void show(){
        for(XmlArticle article : articles){
            System.out.println(article.getTitle());
            System.out.println(article.getContent());
        }
    }

}
