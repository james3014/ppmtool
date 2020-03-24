package com.jwgrant.ppmtool.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Project
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Project Name Required")
    private String projectName;
    @NotBlank(message = "Identifier Required")
    @Size(min = 4, max = 5, message = "4 To 5 Characters")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;
    @NotBlank(message = "Description Required")
    private String description;
    private Date startDate;
    private Date endDate;
    private Date createdAt;
    private Date updatedAt;


    @PrePersist
    protected void onCreate()
    {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate()
    {
        this.updatedAt = new Date();
    }
}
