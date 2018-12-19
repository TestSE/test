package com.test.se.g02.demo;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@Table(name = "PaymentInform")

public class PaymentInform {
    @Id
  
    private @NotNull Long id;

    public PaymentInform(){}
    public PaymentInform(Long id) {
    }

   