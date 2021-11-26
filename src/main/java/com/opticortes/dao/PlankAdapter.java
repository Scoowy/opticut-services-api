package com.opticortes.dao;

import com.google.gson.*;
import com.opticortes.entities.Plank;

import java.lang.reflect.Type;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.25.2217
 */
public class PlankAdapter implements JsonSerializer<Plank>, JsonDeserializer<Plank> {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String DIMENSIONS = "dimensions";
    private static final String HEIGHT = "height";
    private static final String WIDTH = "width";
    private static final String DENSITY = "density";
    private static final String ACTIVE = "active";

    @Override
    public JsonElement serialize(Plank plank, Type type, JsonSerializationContext context) {
        JsonObject plankJson = new JsonObject();

        plankJson.addProperty(ID, plank.getId());
        plankJson.addProperty(NAME, plank.getName());
        plankJson.addProperty(ACTIVE, plank.isActive());

        JsonObject dimensionsJson = new JsonObject();
        dimensionsJson.addProperty(HEIGHT, plank.getHeight());
        dimensionsJson.addProperty(WIDTH, plank.getWidth());
        dimensionsJson.addProperty(DENSITY, plank.getDensity());

        plankJson.add(DIMENSIONS, dimensionsJson);

        return plankJson;
    }

    @Override
    public Plank deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonObject dimensions = jsonObject.getAsJsonObject(DIMENSIONS);

//        int id = jsonObject.get(ID).getAsInt();
        String name = jsonObject.get(NAME).getAsString();
        double height = dimensions.get(HEIGHT).getAsDouble();
        double width = dimensions.get(WIDTH).getAsDouble();
        double density = dimensions.get(DENSITY).getAsDouble();
        boolean active = jsonObject.get(ACTIVE).getAsBoolean();

        return new Plank(name, height, width, density, active);
    }

}
