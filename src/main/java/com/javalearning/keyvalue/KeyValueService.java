package com.javalearning.keyvalue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyValueService {

    private final KeyValueRepository keyValueRepository;

    @Autowired
    public KeyValueService(KeyValueRepository keyValueRepository) {
        this.keyValueRepository = keyValueRepository;
    }

    public String getValue(String key) {
        return keyValueRepository.getValue(key);
    }

    public void addKeyValue(String key, String value) {
        keyValueRepository.addKeyValue(key, value);
    }
}
