package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AfishaItem {
    private int id;
    private String movieName;
    private String pictireUrl;
    private String genre;

}
