package com.example.lombok;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MutableStudent {
    private String name;
    private String email;
    private int rollNo;
    private List<String> hobbies;
    public static final Logger logger = LoggerFactory.getLogger(MutableStudent.class);

    public static void main(String[] args) throws IOException {

//        @Cleanup InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//        @Cleanup BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        @Cleanup OutputStreamWriter streamWriter = new OutputStreamWriter(System.out);
        @Cleanup BufferedWriter bufferedWriter = new BufferedWriter(streamWriter);
        val stud = new MutableStudent("T-Pain", "xyz@example.com", 1, List.of("games"));
//        bufferedWriter.write(stud.toString());
        logger.info(stud.toString());
    }
}
