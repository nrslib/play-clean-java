package com.nrslib.lib.json.objectLoader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.TypeVariable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JsonsFile<T> {
    private final Class<T> clazz;
    private final Path filePath;
    private int current;

    public JsonsFile(Class<T> clazz, String filePath){
        this.clazz = clazz;
        this.filePath = Paths.get(filePath);
    }


    class Test {
        public Optional<String> data;
    }
    public T next() {
        if (!Files.exists(filePath)) {
            return createAnyInstance();
        }

        String content;
        try {
            content = Files.readAllLines(filePath).stream().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
            return createAnyInstance();
        }

        List<String> jsons = splitJsons(content);
        String targetJson = current < jsons.size() ? jsons.get(current) : lastOrDefault(jsons);
        current++;

        if (targetJson == null) {
            return createAnyInstance();
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        try {
            return mapper.readValue(targetJson, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return createAnyInstance();
        }
    }

    private T createAnyInstance() {
        Constructor constructor = clazz.getConstructors()[0];
        try {
            Object[] args = Arrays.stream(constructor.getParameterTypes())
                    .map(x -> {
                        switch (x.getName()){
                            case "java.util.List": return new ArrayList();
                            default: return null;
                        }

                    })
                    .toArray();
            return (T)constructor.newInstance(args);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List<String> splitJsons(String content) {
        List<String> acc = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Integer nest = 0;

        for(Character c : content.toCharArray()) {
            sb.append(c);
            if(c.equals('{')) {
                nest++;
            }else if(c.equals('}')){
                nest--;
                if(nest == 0) {
                    acc.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }

        return acc;
    }

    private <T> T lastOrDefault(List<T> source){
        if(source == null) {
            return null;
        }

        if(source.size() == 0) {
            return null;
        }

        return source.get(source.size() - 1);
    }
}
