import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    private static Document getPage() throws IOException, URISyntaxException {
        URL path = ClassLoader.getSystemResource("html.htm");
        File input = new File(path.toURI());
        Document document = Jsoup.parse(input, "UTF-8");
        return document;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Document document = getPage();

        FileWriter file = null;
        try {
            file = new FileWriter("products.csv");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter write = new PrintWriter(file);
        for (Element element: document.getElementsByClass("item-details")) {
            Product product = new Product(element.select("h3").text(), element.select("p[class=original-price]").text(), element.select("p[class=current-price]").text());
            write.println(product);
        }
        write.close();
    }
}


