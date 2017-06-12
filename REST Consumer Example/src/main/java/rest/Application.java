package rest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import rest.dowjones.Stock;

public class Application {
	//Change this to whatever address you have locally if running both the producer example and the consumer example.
	//garnerj990.zapto.org will not be available
	public final static String URI = "http://garnerj990.zapto.org:8012/stocks";
	public final static String PARAMURI = URI + "/{id}";
    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "1");
        Stock stock = restTemplate.getForObject(PARAMURI, Stock.class, params);
        
        System.out.println(stock.toString());
        stock.setLow(new BigDecimal("999.999"));
        restTemplate.put(PARAMURI, stock, params);
        
        stock = restTemplate.getForObject(PARAMURI, Stock.class, params);
        

        System.out.println(stock.toString());
        String s = restTemplate.getForObject(URI + ".json", String.class);
        
        System.out.println(s);
        
    }
}
