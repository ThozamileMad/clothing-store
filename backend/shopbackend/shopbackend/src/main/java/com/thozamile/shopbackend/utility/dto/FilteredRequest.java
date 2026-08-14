package com.thozamile.shopbackend.utility.dto;

import java.time.LocalDateTime;
import java.util.List;

public record FilteredRequest(
    List<Long> typeIds,
    List<Long> styleIds,
    List<String> colors,
    List<String> sizes,
    Integer minPrice,
    Integer maxPrice,
    String priceRange,
    String dateOrder
) {
    
}