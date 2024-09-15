package com.myprojectspringboot.pointofsale.paginated;


import com.myprojectspringboot.pointofsale.dto.response.ItemGetResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedResponseItemDTO {
    List<ItemGetResponse> activeItems;
    private long dataCount;
}
