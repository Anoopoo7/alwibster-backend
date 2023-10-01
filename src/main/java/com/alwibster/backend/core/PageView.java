/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.core;

import java.util.List;

import org.springframework.data.domain.Pageable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageView<T> {

    public PageView(long matches, List<T> data, Pageable pageable) {
        this.matches = matches;
        this.data = data;
        this.isStartPage = pageable.getPageNumber() == 0;
        this.count = data.size();
        this.isEndPage = (Math.ceil((double) matches / (double) pageable.getPageSize()) - 1) <= pageable
                .getPageNumber();
    }

    public PageView(List<T> data, PageView<?> pageView) {
        this.matches = pageView.getMatches();
        this.data = data;
        this.isStartPage = pageView.isStartPage();
        this.count = pageView.getCount();
        this.isEndPage = pageView.isEndPage();
    }

    private long matches;

    private int count;

    private List<T> data;

    private boolean isStartPage;

    private boolean isEndPage;

}
