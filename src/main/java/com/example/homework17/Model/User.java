package com.example.homework17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer userId;

  @Size(min = 4,message = "should be more then 4 characters")
  @Column(columnDefinition = "varchar(15) not null")
    private String name;

    @Size(min = 4,message = "should be more then 4 characters")
    @Column(columnDefinition = " varchar(15) unique not null")
    private String username;

  @Column(columnDefinition = " varchar(15) not null")
    private String email;

  @Column(columnDefinition = " int not null")
    private Integer password;

  @Column(columnDefinition = " varchar(15) not null check('user || admin')")
    private String role;

    @Positive
    @Column(columnDefinition = " int not null")
    private Integer age;


}
