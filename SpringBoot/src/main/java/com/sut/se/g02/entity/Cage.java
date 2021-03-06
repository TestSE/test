package com.sut.se.g02.entity;


import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@Table(name = "Cage")
public class Cage {
	@Id
	@SequenceGenerator(name="cage_seq",sequenceName="cage_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cage_seq")
    @Column(name="idCage")
	private @NonNull Long cageId;
	private @NonNull String nameCage;

	public Cage() {}

    public Cage (Long id,String nameCage){
        this.nameCage = nameCage;
    }

	public String getNameCage() {
		return nameCage;
	}

	public void setNameCage(String nameCage) {
		this.nameCage = nameCage;
	}
}
