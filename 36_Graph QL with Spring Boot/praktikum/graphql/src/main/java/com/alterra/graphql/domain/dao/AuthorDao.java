package com.alterra.graphql.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthorDao {

    @Id
    private Long id;

    private String name;

    private String thumbnail;

   @ManyToOne
   @JoinColumn(name = "post_id")
   private PostDao post;


}
