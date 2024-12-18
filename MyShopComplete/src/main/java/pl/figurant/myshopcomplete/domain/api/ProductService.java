package pl.figurant.myshopcomplete.domain.api;

import pl.figurant.myshopcomplete.domain.category.Category;
import pl.figurant.myshopcomplete.domain.product.Product;
import pl.figurant.myshopcomplete.domain.product.ProductDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private final ProductDao productDao = new ProductDao();

    public List<ProductInfo> findAll() {
        List<Product> products = productDao.getAll();
        List<ProductInfo> productInfos = new ArrayList<>();
        for (Product product : products) {
            productInfos.add(productInfoTransform(product));
        }

        return productInfos;
    }

    public List<ProductInfo> findByCategoryId(int id) {
        List<Product> products = productDao.getByCategoryId(id);
        List<ProductInfo> productInfos = new ArrayList<>();
        for (Product product : products) {
            productInfos.add(productInfoTransform(product));
        }
        return productInfos;
    }

    public Optional <ProductInfo> findById(int id) {
        return productDao.getById(id).map(productInfoMapper::map);
    }

    public ProductInfo productInfoTransform(Product product) {
        return new ProductInfo(
                product.getId(), product.getName(), product.getDescription(), product.getPrice(),
                product.getIn_stock(), product.getImage(), product.getDiscount()
        );
    }

    private static class productInfoMapper {
        static ProductInfo map(Product p) {
            return new ProductInfo(
                    p.getId(),
                    p.getName(),
                    p.getDescription(),
                    p.getPrice(),
                    p.getIn_stock(),
                    p.getImage(),
                    p.getDiscount()
            );
        }

    }
}
