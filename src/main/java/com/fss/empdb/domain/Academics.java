package com.fss.empdb.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Academics {
    @Id
    @Column(name = "ACADEMICS_ID")
    Long academicsId;

    public Academics() {

    }

    @Column(name = "ACADEMICS_NAME", nullable = false)
    String academicsName;
}

