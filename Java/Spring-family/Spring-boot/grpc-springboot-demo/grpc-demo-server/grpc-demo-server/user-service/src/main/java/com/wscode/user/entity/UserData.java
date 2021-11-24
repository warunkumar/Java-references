package com.wscode.user.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Warun
 * @createdOn 11-10-2021
 **/

@Entity
@Data
@ToString
public class UserData {

    @Id
    private String login;
    private String name;
    private String genre;

}
