package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Аркадий on 14.02.2016.
 */
public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?%sq=java+%s";
    //                                       "https://moikrug.ru/vacancies?page=2&q=java+Dnepropetrovsk"

    @Override
    public List<Vacancy> getVacancies(String searchString) {List<Vacancy> result = new ArrayList<>();
        try {
            int i = 1;
            while(true) {
                Document html = getDocument(searchString, i++);
                Elements elements = html.select("[class~=job .*]");
                if(elements.size() == 0) {
                    break;
                }

                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();
                    Element title = element.getElementsByAttributeValue("class", "title").first();
                    vacancy.setTitle(title.text());
                    vacancy.setUrl("https://moikrug.ru" + title.getElementsByTag("a").attr("href"));
                    vacancy.setSalary(element.getElementsByAttributeValue("class", "salary").text());
                    vacancy.setCity(element.getElementsByAttributeValue("class", "location").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name")
                            .first().getElementsByTag("a").text());
                    vacancy.setSiteName(html.title());
                    result.add(vacancy);
                }
            }
        } catch (IOException ignore) {}

        return result;

        //not mine, suitable for JR
        /*
        List<Vacancy> vacancies = new ArrayList<>();
        try
        {
            Document document;
            int pageCounter = 1;

            while(true)
            {
                document = getDocument(searchString, pageCounter++);
                if(document == null) break;

                Elements elements = document.getElementsByClass("job");//incomprehensible, html has only "job  " and "job marked" classes
                if(elements.size() == 0) break;

                for(Element element : elements)
                {
                    Vacancy vacancy = new Vacancy();

                    vacancy.setUrl( element.getElementsByClass("title").first().child(0).attr("abs:href") );
                    vacancy.setTitle( element.getElementsByAttributeValue("class", "title").text() );
                    vacancy.setCity( element.getElementsByAttributeValue("class", "location").text() );
                    vacancy.setSalary(element.getElementsByAttributeValue("class", "salary").text());
                    vacancy.setSiteName(document.title());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").first().getElementsByTag("a").text());

                    vacancies.add(vacancy);
                }
            }
        }
        catch (Exception e)
        {

        }

        return vacancies;
        */
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.109 Safari/537.36";
        String url;
        if (page == 1) {
            url = String.format(URL_FORMAT, "", searchString);
        } else {
            url = String.format(URL_FORMAT, "page=" + page + "&", searchString);
        }
        return Jsoup.connect(url).userAgent(userAgent).referrer("http://javarush.ru/").get();
    }
}
