package com.example.lombok;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Value
@Slf4j
public class ImmutableStudent {
    String name;
    String email;
    int rollNo;
    List<String> hobbies;

    public static void main(String[] args) {
        ImmutableStudent immutableStudent = new ImmutableStudent("Lemon", "dew@example.com",1, List.of());
        log.info(immutableStudent.toString());
    }
}
