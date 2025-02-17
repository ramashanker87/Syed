package com.syed.app.model;




@Entity
@Table(name = "Student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private int age;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("schoolName")
    private String schoolName;

}

