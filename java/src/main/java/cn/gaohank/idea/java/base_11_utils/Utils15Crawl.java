package cn.gaohank.idea.java.base_11_utils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Utils15Crawl {
    public static void main(String[] args) throws Exception {
        String baseUrl = "http://pro.eye.kuyun.com/tpl/hotrank.html?v=3.0.0";
        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        webClient.getOptions().setJavaScriptEnabled(true);// 默认执行js
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setTimeout(10 * 1000);
        webClient.waitForBackgroundJavaScript(30 * 1000);
        HtmlPage page = webClient.getPage(baseUrl);
        waitJsDataLoad(page);

        // 1.选择节目排行
        DomElement domElement = (DomElement) page.getByXPath("/html/body/div[@id='hot-rank']/div[@class='frame-title']/ul[@class='tabs']/li[2]").get(0);
        HtmlPage result_page = domElement.click();
        waitJsDataLoad(result_page);

        // 2.选择电视剧类型
        DomElement elementById = result_page.getElementById("column-type");
        HtmlElement ul = elementById.getElementsByTagName("ul").get(0);
        DomNodeList<HtmlElement> lis = ul.getElementsByTagName("li");
        HtmlElement li = lis.get(lis.size() - 1);
        HtmlPage htmlPage = li.click();
        DomNodeList<HtmlElement> divs = htmlPage.getElementById("query-column").getElementsByTagName("div");
        HtmlElement htmlElement = divs.get(divs.size() - 1);

        // 3.点击query-btn确定按钮
        HtmlPage pageTV = htmlElement.click();
        waitJsDataLoad(pageTV);
        Document document = Jsoup.parse(pageTV.asXml());
        Elements trs = document.getElementById("hotrank-column").getElementsByClass("rank-list").select("tbody").select("tr");
        List<Rating> tvRating = new ArrayList<>();
        for (int i = 1; i < trs.size(); i++) {
            Elements tds = trs.get(i).getElementsByTag("td");
            Rating rating = new Rating();
            rating.setRank(Integer.valueOf(tds.get(0).text()));
            rating.setShow(tds.get(1).text().split(" ")[0]);
            rating.setChannel(tds.get(2).text());
            rating.setRate(tds.get(4).select("span").text().split("%")[0]);
            rating.setType("电视剧");
            tvRating.add(rating);
        }
        tvRating.forEach(System.out::println);
    }

    @Data
    @NoArgsConstructor
    public static class Rating {
        private int rank;
        private String show;
        private String type;
        private String channel;
        private String rate;
    }

    private static void waitJsDataLoad(HtmlPage page) throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            if (!page.getByXPath("table").isEmpty()) {
                break;
            }
            synchronized (page) {
                page.wait(1000);
            }
        }
    }
}
