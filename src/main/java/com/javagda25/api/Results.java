package com.javagda25.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Results {
    private String title;
    private String href;
    private String ingredients;
    private String thumbnail;

}
