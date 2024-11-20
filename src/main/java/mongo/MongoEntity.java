package com.example.lab4.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "mongo_entity")
@Data
public class MongoEntity {
    @Id
    private String id;
    private String name;
    private String description;
}
