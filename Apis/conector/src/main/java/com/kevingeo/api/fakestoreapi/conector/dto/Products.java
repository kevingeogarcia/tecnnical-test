package com.kevingeo.api.fakestoreapi.conector.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Products implements Serializable {

    private static final long serialVersionUID = -7817224776021724382L;


    private Long id;
    private String title;
    private BigDecimal price;
    private String description;
    private String category;
    private String image;
}

