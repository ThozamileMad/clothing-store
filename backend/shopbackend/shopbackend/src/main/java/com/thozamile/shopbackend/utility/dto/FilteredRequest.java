package com.thozamile.shopbackend.utility.dto.FilteredRequest;

public record FilteredRequest(
    Long typeId,
    Long styleId,
    String priceRange,
    Boolean latest 
) {
    
}