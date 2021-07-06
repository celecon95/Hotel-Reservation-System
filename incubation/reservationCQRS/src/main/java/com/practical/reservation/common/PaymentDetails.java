package com.practical.reservation.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "PaymentDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {

    @ApiModelProperty(
            value = "price",
            dataType = "Double",
            example = "1500")
    private Double price;

    @ApiModelProperty(
            value = "modeOfPayment",
            dataType = "String",
            example = "Debit card")
    private String modeOfPayment;
}
