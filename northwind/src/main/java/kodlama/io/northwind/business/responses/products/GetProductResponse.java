package kodlama.io.northwind.business.responses.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProductResponse {
	private int id;
	private String name;
	private String categoryName;
	private int unitsInStock;
	private double unitPrice;
}
