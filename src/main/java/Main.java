import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class Main {

    private static Document getPage() throws IOException, URISyntaxException {
        URL path = ClassLoader.getSystemResource("html.htm");
        File input = new File(path.toURI());
        Document document = Jsoup.parse(input, "UTF-8");
        return document;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        ArrayList<String> arrayList = new ArrayList<>();
        Document page = getPage();
        Elements element = page.getElementsByClass("item-details");
        for (Element aElement: element) {
            arrayList.add(element.select("h3").text());
            arrayList.add(element.select("p[class=original-price]").text());
            arrayList.add(element.select("p[class=current-price]").text());
        }
        FileWriter file = null;
        try {
            file = new FileWriter("products.csv");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter write = new PrintWriter(file);
        for (String name: arrayList) {
            write.println(name);
        }
        write.close();
    }
}



