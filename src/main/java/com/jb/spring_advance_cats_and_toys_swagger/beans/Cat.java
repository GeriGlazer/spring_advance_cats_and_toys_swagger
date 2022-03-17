package com.jb.spring_advance_cats_and_toys_swagger.beans;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cats")
@NoArgsConstructor
@AllArgsConstructor
@Getter  @Setter
@Builder
@ToString
public class Cat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private  int id;
    @Column(nullable = false, length = 40)
    private  String name;
    private float weight;
    @Singular("toy")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "toy_id")
    private List<Toy> toyList;
}
