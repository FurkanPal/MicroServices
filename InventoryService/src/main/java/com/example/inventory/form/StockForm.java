package com.example.inventory.form;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class StockForm {
    @NonNull
    private String sku_code;
    private String inventory;
}
