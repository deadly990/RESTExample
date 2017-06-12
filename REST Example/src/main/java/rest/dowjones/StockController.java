package rest.dowjones;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/stocks")
public class StockController {
	private StockRepository stockRepository;
	public StockController() {
		//I should be using dependency injection to facilitate proper testing
		//Since this is a simple DEMO REST I have omitted this
		stockRepository = new StockRepository();
	}
	@RequestMapping(value = "{id}", method = GET)
    public Stock getOne(@PathVariable("id") long id) {
        return stockRepository.GetStock(id);
    }
    @RequestMapping(method = POST)
    public Stock create(@RequestBody Stock stock) {
        return stockRepository.CreateStock(stock);
    }
    @RequestMapping(value = "{id}", method = DELETE)
    public void delete(@PathVariable("id") long id) {
        stockRepository.DeleteStock(id);
    }
    @RequestMapping(value = "{id}", method = PUT)
    public Stock update(@PathVariable long id, @RequestBody Stock stock) {
        return stockRepository.UpdateStock(id, stock);
    }
}