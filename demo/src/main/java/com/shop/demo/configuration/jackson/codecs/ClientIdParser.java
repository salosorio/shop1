package com.shop.demo.configuration.jackson.codecs;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.shop.demo.domain.CartId;
import com.shop.demo.domain.ClientId;

import java.io.IOException;

public class ClientIdParser {
    public static class Serializer extends JsonSerializer<ClientId> {
        @Override
        public void serialize(ClientId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<ClientId> {
        @Override
        public ClientId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return ClientId.fromString(p.getValueAsString());
        }
    }

}
