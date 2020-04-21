package com.fss.empdb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PROJECT_ID")
    Long projectId;

    /*@OneToMany(cascade = CascadeType.MERGE, mappedBy = "departmentId")
    private Collection<Department> department;*/

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;



    @Column(name="PROJECT_NAME",nullable = false)
    String projectName;

    @Column(name="PROJECT_MANAGER",nullable = false)
    String projectManager;

    @Column(name="PROJECT_STATUS",nullable = false)
    String projectStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = "PROJECT_START_DATE", nullable = false)
    Date projectStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "PROJECT_END_DATE", nullable = false)
    Date projectEndDate;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "regionId")
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "REGION_ID")
    private Region region;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    //@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "projectTaggingId")
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "PROJECT_TAGGING_ID")
    private ProjectTagging projectTagging;

    @JsonIgnore
    @Column(name="INS_USER")
    Long insUser;

    @JsonIgnore
    @Temporal(TemporalType.DATE)
    @Column(name="INS_DATE")
    Date insDate;

    @JsonIgnore
    @Column(name="LAST_UPDATE_USER")
    Long lastUpdateUser;

    @JsonIgnore
    @Temporal(TemporalType.DATE)
    @Column(name="LAST_UPDATE_DATE")
    Date lastUpdateDate;
}
