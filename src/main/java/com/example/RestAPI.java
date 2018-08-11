package com.example;



import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.RentObject;

@Path("function")
public class RestAPI {
	
	@GET
	@Path("search")
    @Produces("application/json; charset=UTF-8")
    public String search(@QueryParam("kind") int kind, @QueryParam("region") int region, @QueryParam("firstRow")int firstRow) throws IOException  {
		Document doc = Jsoup.connect(String.format("https://rent.591.com.tw/?kind=%d&region=%d&firstRow=%d", kind, region, firstRow)).timeout(30000).cookie("urlJumpIp",String.valueOf(region)).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36").validateTLSCertificates(false).get();
		Elements  objects = doc.select(".listInfo").select(".clearfix");

		String out = "";
		ArrayList<RentObject> temp = new ArrayList<RentObject>();
		for(Element object: objects) {
			String picture = object.select(".pull-left").select(".imageBox").select("img").first().attr("data-original");
			String title = object.select(".pull-left").select(".infoContent").select("a").first().text();
			String type =  object.select(".pull-left").select(".infoContent").select(".lightBox").get(0).text();
			String address = object.select(".pull-left").select(".infoContent").select("em").get(0).text();
			String contact = object.select(".pull-left").select(".infoContent").select("em").get(1).text();
			String detail = object.select(".pull-left").select(".infoContent").select("a").first().attr("href");
			int price =  Integer.parseInt(object.select(".price").text().split(" ")[0].replace(",",""));
			
			temp.add(new RentObject( picture, title,  type,  address,  contact, price, detail, null) );
			//out += new JSONObject(new RentObject( picture, title,  type,  address,  contact, price, detail, null)).toString();
		}
		
		RentObject [] results = new RentObject[temp.size()];
		results = temp.toArray(results);
        return new JSONArray(results).toString();
    }
}
