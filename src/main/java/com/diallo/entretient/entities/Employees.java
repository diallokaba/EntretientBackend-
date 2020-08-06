package com.diallo.entretient.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employees {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String prenom;
    String email;
    String password;

    //pour une meilleure lecture du code json
    @Override
    public String toString() {
        return "Employee [id=" + id + ", first-Name=" + nom+ ", last-Name=" + prenom+ ", email-Id=" + email+ ", password=" + password
                + "]";
    }
}
