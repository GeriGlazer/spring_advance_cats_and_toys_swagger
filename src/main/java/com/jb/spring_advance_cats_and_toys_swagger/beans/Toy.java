package com.jb.spring_advance_cats_and_toys_swagger.beans;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "toys")
@NoArgsConstructor
@AllArgsConstructor
@Getter  @Setter
@Builder
@ToString
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toy_Id")
    private int id;
    @Column(nullable = false, length = 40)
    private String name;
//    @ManyToMany (fetch = FetchType.EAGER)
//    @JoinColumn (name = "cat_id")
//    private List<Cat> cat;

}
