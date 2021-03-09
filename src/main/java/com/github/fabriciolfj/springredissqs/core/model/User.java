package com.github.fabriciolfj.springredissqs.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
@EqualsAndHashCode
public class User implements Serializable {

    private static final long serialVersionUID = 7345184151693019567L;

    private Integer id;
    private String name;
    private BigDecimal salary;
}
