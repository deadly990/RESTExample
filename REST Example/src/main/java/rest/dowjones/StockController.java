package rest.dowjones;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	private StockFactory stockFactory;
	public StockController() {
		//I should be using dependency injection
		//Since this is a simple DEMO REST application this is not required
		stockFactory = new StockFactory();
	}
    @RequestMapping(value = "/stocks/{id}")
    public Stock stock(@PathVariable("id") long id) {
    	System.out.println(id);
        return stockFactory.GetStock(id);
    }
}