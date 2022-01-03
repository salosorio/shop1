package com.shop.demo.repository;

import com.shop.demo.domain.CartId;
import com.shop.demo.domain.ClientId;
import com.shop.demo.domain.Cart;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Component
public class SpringJdbcCartRepository implements CartRepository {
    private final JdbcTemplate jdbcTemplate;

    public SpringJdbcCartRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Cart> rowMapper = (resultSet, rowNum) -> {
        CartId cartId = CartId.fromString(
                resultSet.getString("id_Cart")
        );

        ClientId clientId = ClientId.fromString(resultSet.getString("client"));

        Timestamp createdDate = resultSet.getTimestamp("createdDT");

        Timestamp updatedDate = resultSet.getTimestamp("updatedDT");

        BigDecimal total = resultSet.getBigDecimal("total");

        return new Cart(
                cartId,
                clientId,
                createdDate,
                updatedDate,
                total

        );
    };
    //usamos lenguaje SQL
    @Override
    public List<Cart> list() {
        String sqlQuery = "select * from cart ";
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }

    @Override
    public Cart findOne(CartId id) {
        String sqlQuery = "select * from cart where id_Cart = ?";

        return jdbcTemplate.queryForObject(sqlQuery, rowMapper, id.toString());
    }

    @Override
    public void create(Cart cart) {
        String sqlQuery = "insert into cart(id_Cart, client, createdDT, updatedDT, total) values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, sp -> {
            sp.setString(1, cart.getCartId().toString());
            sp.setString(2, cart.getClientId().toString());
            sp.setTimestamp(3, cart.getCreatedDate());
            sp.setTimestamp(4, cart.getUpdatedDate());
            sp.setBigDecimal(5, cart.getTotal());
        });
    }
    //usamos siempre where para que no actualice toda la tabla
        @Override
        public void update(CartId id, Cart cart){
            String sqlQuery = "update cart set  updatedDT = ?, total = ? where id_Cart = ?";
            jdbcTemplate.update(sqlQuery, sp -> {

                sp.setTimestamp(1, cart.getUpdatedDate());
                sp.setBigDecimal(2, cart.getTotal());
                sp.setString(3, id.toString());
            });

        }

    //usamos siempre where para que no elimine toda la tabla
        @Override
        public void delete(CartId id) {
            String sqlQuery = "delete from cart where id_Cart = ?";
            jdbcTemplate.update(sqlQuery, id.getValue().toString());
        }

}
