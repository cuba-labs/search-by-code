package com.company.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s|code,title")
@Table(name = "DEMO_SPARE_PART")
@Entity(name = "demo$SparePart")
public class SparePart extends StandardEntity {
    private static final long serialVersionUID = -6441836613524652584L;

    @Column(name = "CODE", nullable = false, unique = true)
    protected Integer code;

    @Column(name = "TITLE", nullable = false, unique = true)
    protected String title;

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}