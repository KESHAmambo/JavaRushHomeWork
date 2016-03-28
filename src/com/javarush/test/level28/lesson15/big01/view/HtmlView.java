package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

/**
 * Created by Аркадий on 13.02.2016.
 */
public class HtmlView implements View {
    private final String filePath = "./src/" + getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        System.out.println(vacancies.size());
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }
    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException
    {
        Document doc = getDocument();
        Element element = doc.getElementsByClass("template").first();
        Element cloneElement = element.clone();
        cloneElement.removeClass("template").removeAttr("style");
        doc.getElementsByAttributeValue("class","vacancy").remove();
        for (Vacancy vacancy : vacancies)
        {
            Element vac = cloneElement.clone();
            vac.getElementsByAttributeValue("class", "city").first().text(vacancy.getCity());
            vac.getElementsByAttributeValue("class", "companyName").first().text(vacancy.getCompanyName());
            vac.getElementsByAttributeValue("class", "salary").first().text(vacancy.getSalary());
            Element link = vac.getElementsByTag("a").first();
            link.text(vacancy.getTitle());
            link.attr("href", vacancy.getUrl());
            element.before(vac.outerHtml());
        }
        return doc.html();
    }
    /*
    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException {
        Document doc = getDocument();
        Element template = doc.getElementsByClass("template").first();
        Element tempClone = template.clone();
        Eelement elements = doc.getElementsByClass("vacancy");
        for (element elelement elements) {
         element!element.hasClass("template")) {
        element element.remove();
            }
        }
        //System.out.element(elements);
        tempClone.removeAttr("style");
        tempClone.removeClass("template");
        for (Vacancy vacancy : vacancies) {
            Element newElement = tempClone.clone();
            Element title = newElement.getElementsByClass("title").first();
            title.appendText(vacancy.getTitle());
            title.getElementsByTag("a").first().attr("href", vacancy.getUrl());
            Element city = newElement.getElementsByClass("city").first();
            city.append(vacancy.getCity());
            Element companyName = newElement.getElementsByClass("companyName").first();
            companyName.append(vacancy.getCompanyName());
            Element salary = newElement.getElementsByClass("salary").first();
            salary.append(vacancy.getSalary());
            //doc.body().getElementsByTag("table").first().getElementsByTag("tbody").first().appendChild(newElement);
            template.before(newElement.outerHtml());
        }
            /*
    element elements = doc.getElementsByClass("vacancy");
            for(element eelement elements) {
                Elementelement element.getElementsByClass("city").first();
                System.out.println(city.text());
            }
            System.out.println(doc.title());
            -----
            //System.out.println(template);
            //System.out.println("\nDOC:\n" + doc);
        return doc.html();
    }
    */

    private void updateFile(String name) throws IOException {

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
        pw.write(name);
        pw.close();

        /*
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(name);
        if (fileWriter != null) {
            fileWriter.close();
        }
        */

        /*
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
        bw.write(name);
        bw.close();
        */
        /*
        FileOutputStream fos = new FileOutputStream(filePath);
        fos.write(name.getBytes());
        fos.close();
        */

        /*
        FileWriter fileWriter = new FileWriter("c:/javaidea/try.txt");
        Scanner scanner = new Scanner(name);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
            fileWriter.write(line);
            fileWriter.write(System.lineSeparator());
        }
        fileWriter.close();
        */
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
