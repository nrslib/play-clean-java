package com.nrslib.lib.json.objectLoader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JsonsLoader {
    private final String fileDirectoryPath;
    private Map<Class, JsonsFile> files = new HashMap<>();

    public JsonsLoader(String fileDirectoryFullPath) {
        this.fileDirectoryPath = fileDirectoryFullPath;
    }

    public <T> T generate(Class<T> clazz) {
        if(!files.containsKey(clazz)){
            files.put(clazz, createDefaultFiles(clazz));
        }

        JsonsFile<T> jsonsFile = files.get(clazz);
        return jsonsFile.next();
    }

    private <T> JsonsFile<T> createDefaultFiles(Class<T> clazz) {
        String filePath = new File(fileDirectoryPath, clazz.getSimpleName() + ".jsons").getPath();
        return new JsonsFile<>(clazz, filePath);
    }
}
