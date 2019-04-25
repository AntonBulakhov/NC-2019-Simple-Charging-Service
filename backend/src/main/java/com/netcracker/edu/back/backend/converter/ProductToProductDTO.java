package com.netcracker.edu.back.backend.converter;

import com.netcracker.edu.back.backend.dto.ProductDTO;
import com.netcracker.edu.back.backend.entity.Product;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class ProductToProductDTO implements Converter<Product, ProductDTO> {
    private UserToUserDTO toUserDTO = new UserToUserDTO();

    @Override
    public ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setLogoUrl(product.getLogoUrl());
        productDTO.setVideolink(product.getVideolink());
        productDTO.setCategory(product.getCategory());
        productDTO.setUser(toUserDTO.convert(product.getUser()));
        return productDTO;
    }

    public List<ProductDTO> convert(List<Product> products){
        List<ProductDTO> list = new ArrayList<>();
        for (Product pro: products) {
            list.add(convert(pro));
        }
        return list;
    }
}
