package pl.michalkruczek.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.*;
import pl.michalkruczek.server.dto.ProductDto;
import pl.michalkruczek.server.model.Product;
import pl.michalkruczek.server.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikr on 26/08/17.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public ProductRepository productRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@RequestBody ProductDto productDto) throws ParseException{ //TODO check parseexception!!
        Product product = new Product();

        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        productRepository.save(product);

        return "Success - add product [" + product.getName() + "].";
    }

    @RequestMapping("/all")
    public List<ProductDto> allProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<ProductDto>();

        for (Product product : productList) {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setDescription(product.getDescription());
            productDto.setPrice(product.getPrice());

            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    @RequestMapping("/{id}")
    public ProductDto singleProduct(@PathVariable long id) {
        Product product = productRepository.findOne(id);

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());

        return productDto;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable long id, @RequestBody ProductDto productDto) {

        Product product = productRepository.findOne(id);

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        productRepository.save(product);

        return "Update product - success [" + product.getName() + "].";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable long id) {

        String nameOfProduct = productRepository.findOne(id).getName();

        productRepository.delete(id);

        return "Delete product [" + nameOfProduct + "].";
    }
}
