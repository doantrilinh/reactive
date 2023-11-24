package com.example.reactive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T24RT.MD")
@Accessors(chain = true)
public class Md {
    @Column("MD_DEAL_NO")
    private String mdDealNo;
    @Column("MD_CURRENCY")
    private String mdCurrency;
}