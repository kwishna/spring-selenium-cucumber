package com.example.lombok;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@EqualsAndHashCode(cacheStrategy = EqualsAndHashCode.CacheStrategy.LAZY, callSuper = false, doNotUseGetters = false)
@Builder
@ToString
@AllArgsConstructor
//@NoArgsConstructor(staticName = "of")
@NoArgsConstructor
@RequiredArgsConstructor /* Generate a constructor with only the required fields.
Required fields are non-initialized final fields and fields annotated with @NonNull.
*/
public class Person {

    @NonNull
    @Getter
    @Setter
    @With
    private String name;
    @NonNull
    @Getter
    @Setter
    @With
    private String email;
    @Getter
    @Setter
    @With
    private int age;
    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    @With
    private List<String> hobbies;

    public static final Logger logger = LoggerFactory.getLogger(Person.class);


    public static void main(String[] args) {
        Person person = Person.builder().age(11).email("abc@example.com").name("Han").build();
//        System.out.println(person);
        logger.info(person.toString());

        Person person1 = person.withHobbies(List.of("cricket", "basketball"));
//        System.out.println(person1);
        logger.info(person1.toString());

    }
}
