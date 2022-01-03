package com.shop.demo.repository;

import com.shop.demo.domain.Currency;
import com.shop.demo.domain.Product;
import com.shop.demo.domain.ProductId;
import com.shop.demo.domain.ProductPrice;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class SpringJdbcProductRepository implements ProductRepository{
        private final JdbcTemplate jdbcTemplate;

        public SpringJdbcProductRepository(JdbcTemplate jdbcTemplate) {

            this.jdbcTemplate = jdbcTemplate;
        }

        private final RowMapper<Product> rowMapper = (resultSet, rowNum) -> {
            ProductId productId = ProductId.fromString(
                    resultSet.getString("product_id")
            );

            String name = resultSet.getString("name");

            String description = resultSet.getString("description");

            ProductPrice productPrice = new ProductPrice(resultSet.getBigDecimal("price"));

            return new Product(
                    productId,
                    name,
                    description,
                    productPrice

            );
        };

        @Override
        public List<Product> list() {
            String sqlQuery = "select * from product ";
            return jdbcTemplate.query(sqlQuery, rowMapper);
        }


    @Override
        public Product findOne(ProductId id) {
            String sqlQuery = "select * from product where product_id = ?";

            return jdbcTemplate.queryForObject(sqlQuery, rowMapper, id.toString());
        }

        @Override
        public void create(Product product) {
            String sqlQuery = "insert into product(product_id, name, description, price) values(?, ?, ?, ?)";
            jdbcTemplate.update(sqlQuery, pd -> {
                pd.setString(1, product.getId().toString());
                pd.setString(2, product.getName());
                pd.setString(3, product.getDescription());
                pd.setBigDecimal(4, product.getPrice().getValue());

            });
        }

            @Override
            public void update(ProductId id, Product product) {
                String sqlQuery = "update product set name = ?, description = ?, price = ? where product_id = ?";
                jdbcTemplate.update(sqlQuery, pd -> {
                    pd.setString(1, product.getName());
                    pd.setString(2, product.getDescription());
                    pd.setBigDecimal(3, product.getPrice().getValue());
                    pd.setString(4, id.toString());
                });

            }
            @Override
            public void delete(ProductId id) {
                String sqlQuery = "delete from product where product_id = ?";
                jdbcTemplate.update(sqlQuery, id.getValue().toString());
            }

        }

