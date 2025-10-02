package cz.malanak.factories;


import cz.malanak.Serialization.Serializer;

public class SerializerFactory {
    public static Serializer createSerializer() {return new Serializer();}
}
