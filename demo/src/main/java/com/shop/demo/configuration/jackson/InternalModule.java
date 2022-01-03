package com.shop.demo.configuration.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.shop.demo.configuration.jackson.codecs.CartIdParser;
import com.shop.demo.configuration.jackson.codecs.ClientIdParser;
import com.shop.demo.configuration.jackson.codecs.ProductIdParser;
import com.shop.demo.configuration.jackson.codecs.ProductPriceCodecs;
import com.shop.demo.domain.CartId;
import com.shop.demo.domain.ClientId;
import com.shop.demo.domain.ProductId;
import com.shop.demo.domain.ProductPrice;

public class InternalModule extends SimpleModule {

    private static final String NAME = "InternalModule";

    public InternalModule() {
        super(NAME, Version.unknownVersion());


        addSerializer(CartId.class, new CartIdParser.Serializer());
        addDeserializer(CartId.class, new CartIdParser.Deserializer());

        addSerializer(ClientId.class, new ClientIdParser.Serializer());
        addDeserializer(ClientId.class, new ClientIdParser.Deserializer());

        addSerializer(ProductId.class, new ProductIdParser.Serializer());
        addDeserializer(ProductId.class, new ProductIdParser.Deserializer());

        addSerializer(ProductPrice.class, new ProductPriceCodecs.Serializer());
        addDeserializer(ProductPrice.class, new ProductPriceCodecs.Deserializer());
    }
}
