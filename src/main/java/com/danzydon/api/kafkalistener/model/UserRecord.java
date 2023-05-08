package com.danzydon.api.kafkalistener.model;

import lombok.Data;

@Data
public class UserRecord {
    private String name;
    private String email;

    public UserRecord() {}
}
