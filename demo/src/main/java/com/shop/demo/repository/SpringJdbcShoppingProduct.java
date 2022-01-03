package com.shop.demo.repository;

import com.shop.demo.domain.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringJdbcShoppingProduct  implements ShoppingProductRepository{

    private final JdbcTemplate jdbcTemplate;

    public SpringJdbcShoppingProduct(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

        private final RowMapper<ShoppingProduct> rowMapper = (resultSet, rowNum) -> {
            CartId cartId = CartId.fromString(
                    resultSet.getString("id_Cart")
            );

            ProductId productId = ProductId.fromString(resultSet.getString("product_id"));

            Integer quantProd = resultSet.getInt("quant_Product");

            return new ShoppingProduct(
                    cartId,
                    productId,
                    quantProd
            );
    };

    @Override
    public List<ShoppingProduct> list() {
        String sqlQuery = "select * from shopping_product ";
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }

    @Override
    public List<ShoppingProduct> listByCartId(CartId cartId) {
        String sqlQuery = "select * from shopping_product where id_Cart = ?";
        return jdbcTemplate.query(sqlQuery, rowMapper, cartId.getValue().toString());
    }

    @Override
    public ShoppingProduct findOne(CartId cartId, ProductId productId) {
        //ponemos dos parametros para que me devuelva 1 registro y no N registros
        String sqlQuery = "select * from shopping_product where id_Cart = ? and product_id = ?";

        return jdbcTemplate.queryForObject(sqlQuery, rowMapper, cartId.toString(), productId.toString());
    }


    @Override
    public void create(ShoppingProduct shoppingProduct) {
        String sqlQuery = "insert into shopping_product(id_Cart, product_id, quant_Product) values(?, ?, ?)";
        //Se organiza de forma ordenada como esta en el sql
        jdbcTemplate.update(sqlQuery, sp -> {
            sp.setString(1, shoppingProduct.getCartId().toString());
            sp.setString(2, shoppingProduct.getProductId().toString());
            sp.setInt(3, shoppingProduct.getQuantProd());


        });
    }
        @Override
        public void update(CartId cartId, ProductId productId, ShoppingProduct shoppingProduct) {
            String sqlQuery = "update shopping_product set quant_Product = ? where id_Cart = ? and product_id = ?";
            jdbcTemplate.update(sqlQuery, sp -> {
                sp.setInt(1, shoppingProduct.getQuantProd());
                sp.setString(2, shoppingProduct.getCartId().toString());
                sp.setString(3, shoppingProduct.getProductId().toString());

            });
        }

        @Override
        public void delete(CartId cartId, ProductId productId) {
             String sqlQuery = "delete from shopping_product where id_Cart = ? and product_id = ? ";
             jdbcTemplate.update(sqlQuery, cartId, productId);
    }




}
