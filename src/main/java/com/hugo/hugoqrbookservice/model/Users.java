package com.hugo.hugoqrbookservice.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class Users {
    @Id
    private final ObjectId id;
    private final String username;
    private final String password;
}
