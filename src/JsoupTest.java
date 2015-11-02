/**
 * Created by michaelklein on 10/26/15.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Calendar;

import java.io.IOException;

public class JsoupTest {

    public static void main(String[] args) {
        // JSoup Example 2 - Reading HTML page from URL
        Document doc;
        String hiToday = null;
        Calendar now = Calendar.getInstance();
        System.out.println(now.getTime());
        now.add(Calendar.DATE, -1);
        System.out.println(now.get(Calendar.DAY_OF_MONTH));

        try {
            doc = Jsoup.connect("http://www.wkow.com/global/interface/httprequest/hrproxy.asp?url=http%3A%2F%2Fdata-services.wsi.com%2F200904-01%2F426717546%2FWeather%2FReport%2F53706&rand=852947").get();

            Elements e = doc.select("DailyForecast Day[DayNum=1]");
            //for (Element e : links) {

                System.out.println("Date: " + e.attr("ValidDateLocal") + "\nHigh Temp: " + e.attr("HiTempF") + "\nLow Temp: " + e.attr("LoTempF"));
                hiToday = e.attr("HiTempF");
            System.out.println("High Temp Variable: " + hiToday);
            //}

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            doc = Jsoup.connect("http://www.wkow.com/global/interface/httprequest/hrproxy.asp?url=http%3A%2F%2Fdata-services.wsi.com%2F200904-01%2F426717546%2FWeather%2FReport%2F53706&rand=852947").get();

            for (Element e : doc.select("DailyForecast")) {
                for (Element e1 : e.select("Day")) {
                    String weather = e1.attr("Sunset").toString();
                    System.out.println(weather);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //doc = Jsoup.connect("http://www.accuweather.com/en/us/madison-wi/53704/october-weather/23278_pc").get();
            doc = Jsoup.connect("http://api.wunderground.com/api/ba6c4ba57593f198/yesterday/q/WI/Madison.xml").get();
            Elements e = doc.select("dailysummary summary maxtempi");

            //Elements e = doc.select(".box h3.date");
            /*for (Element e1 : e.select("h3.date")) {
                System.out.println(e.select("h3.date").text());
                System.out.println(Integer.toString(now.get(Calendar.DAY_OF_MONTH)));
                if (e1.text() == Integer.toString(now.get(Calendar.DAY_OF_MONTH))) {
                    Element found = e1.parent();
                    Element result = found.select("span.temp").first();
                    Element result2 = found.select("span.lo").first();
                    System.out.println("Previous High: " + result.text().replace("°", ""));
                    System.out.println("Previous Low: " +result2.text().replace("°", ""));
                } else {
                    System.out.println("Did not WORK!!!");
                }

            }
            */


            if (e.isEmpty()) {
                System.out.println("Does not work!!!!");
            } else {
                System.out.println(e);
            }

                //Elements e1 = e.select(".info .actual span.temp");
                //Elements e2 = e1.select(".info .actual span.temp");
                //Elements e3 = e2.select("span.temp");

/*
                for (Element e1 : doc.select(".info .actual")) {
                    for (Element e2 : e1.select("span.temp")) {
                        System.out.println(e2.text());
                        //String weather = e1.attr("Sunset").toString();
                        //System.out.println(e.select("span.temp"));
                        //System.out.println(e2.text());
                    }
                }
                */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}