package rest;

import java.math.BigDecimal;

import org.springframework.web.client.RestTemplate;

import rest.dowjones.Stock;

public class Application {
    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Stock stock = restTemplate.getForObject("http://garnerj990.zapto.org:8012/stocks/1", Stock.class);
        
        System.out.println(stock.toString());
        stock.setLow(new BigDecimal("999.999"));
        restTemplate.put("http://garnerj990.zapto.org:8012/stocks/1", stock);
        
        stock = restTemplate.getForObject("http://garnerj990.zapto.org:8012/stocks/1", Stock.class);
        
        System.out.println(stock.toString());
        
    }
}
