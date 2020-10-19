package org.spring.server;

import java.util.Base64;

public class ClassLoaderTest extends ClassLoader{

    @Override
    public Class<?> findClass(String name) {
        String base64 = "yv66vgAAADQAHAoABgAOCQAPABAIABEKABIAEwcAFAcAFQEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAVoZWxsbwEAClNvdXJjZUZpbGUBAApIZWxsby5qYXZhDAAHAAgHABYMABcAGAEAE0hlbGxvLCBjbGFzc0xvYWRlciEHABkMABoAGwEABUhlbGxvAQAQamF2YS9sYW5nL09iamVjdAEAEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2YS9pby9QcmludFN0cmVhbTsBABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgAhAAUABgAAAAAAAgABAAcACAABAAkAAAAdAAEAAQAAAAUqtwABsQAAAAEACgAAAAYAAQAAAAEAAQALAAgAAQAJAAAAJQACAAEAAAAJsgACEgO2AASxAAAAAQAKAAAACgACAAAABAAIAAUAAQAMAAAAAgAN";
        byte[] bytes = Base64.getDecoder().decode(base64);
        return defineClass(name, bytes, 0, bytes.length);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        Object o = classLoaderTest.findClass("Hello").newInstance();
        System.out.println(o);
    }
}
