package com.ifcoder.projetodacc_jpa.model.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author jose
 */
//A anotation @Data cria getter, setter, toString, hascode, equals...
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
//@DiscriminatorValue("FUNCIONARIO")
public class Funcionario extends Pessoa {

    private String email;  
}
