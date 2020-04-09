package com.fss.empdb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
public class Grade {
    @Id
    @Column(name = "GRADE_ID")
    Long gradeId;

    public Grade() {

    }

    @Column(name = "GRADE_NAME", nullable = false)
    String gradeName;

}