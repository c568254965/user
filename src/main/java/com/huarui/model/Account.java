package com.huarui.model;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by sloan on 2019/7/13.
 */

@Data
@Table(name = "account")
public class Account {

    @Id
    private Long id;
    private String name;
}
