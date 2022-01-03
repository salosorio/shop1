package com.shop.demo.controller;

import com.shop.demo.domain.*;
import com.shop.demo.model.CreateCartInput;
import com.shop.demo.model.CreateCartOutput;
import com.shop.demo.model.UpdateCartInput;
import com.shop.demo.model.UpdateCartOutput;
import com.shop.demo.services.CartServices;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping(value = "/cart") //Request Maping es el nos dirije a la direccion o el [path]
public class CartController {
  private final CartServices services;

  public CartController(CartServices services) {

    this.services = services;
  }

  //existe el [get list] y el [get one]
  @GetMapping
  public List<Cart> listCart() {
    return services.listCart();
  }

  //endpoint para crear la cart
  @PostMapping
  public CreateCartOutput createCart(@RequestBody CreateCartInput input) {
    ClientId clientId = input.getClientId();
    Timestamp createdDate = Timestamp.valueOf(LocalDateTime.now());
    Timestamp updatedDate = Timestamp.valueOf(LocalDateTime.now());
    BigDecimal total = input.getTotal();
    CartId random = CartId.random();
    Cart cart = new Cart(random, clientId, createdDate, updatedDate, total);
    Cart createdCart = services.createCart(cart,input.getProducts());//se crea el carrito y  los productos asosciados conn el carrito

    return new CreateCartOutput(createdCart);
  }

  //lo que hace es buscar el id del path
  @GetMapping(value = "/{id}")
  public Cart getCart(@PathVariable("id") String cartId) {
    final CartId id = CartId.fromString(cartId);
    return services.getCart(id);
  }

  //endpoint lo que hace es  buscar de id path para poder eliminar
  @DeleteMapping(value = "/{id}")
  public void deleteCart(@PathVariable("id") String cartId) {
    final CartId id = CartId.fromString(cartId);
    services.deleteCart(id);
  }

  //recibe el id por el path para poder actualizar
  @PutMapping(value = "/{id}")
  public UpdateCartOutput updateCart(@PathVariable("id") String unsafeId, @RequestBody UpdateCartInput input) {
    final CartId id = CartId.fromString(unsafeId);
    Timestamp updatedDate = Timestamp.valueOf(LocalDateTime.now());
    Cart newCart = new Cart(id, updatedDate, input.getTotal());
    final Cart updated = services.updateCart(id, newCart);
    return new UpdateCartOutput(updated);
  }
}
