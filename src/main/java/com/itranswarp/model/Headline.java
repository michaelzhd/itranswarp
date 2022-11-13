package com.itranswarp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "headlines", indexes = @Index(name = "IDX_PUB", columnList = "published,publishAt"))
public class Headline extends AbstractEntity {

    @Column(nullable = false, updatable = false)
    public long userId;

    @Column(nullable = false, length = VAR_CHAR_NAME)
    public String name;

    @Column(nullable = false, length = VAR_CHAR_DESCRIPTION)
    public String description;

    @Column(nullable = false, length = VAR_CHAR_URL)
    public String url;

    @Column(nullable = false)
    public long publishAt;

    @Column(nullable = false)
    public boolean published;

}