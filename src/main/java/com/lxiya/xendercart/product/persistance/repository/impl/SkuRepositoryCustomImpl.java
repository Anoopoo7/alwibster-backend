/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.product.persistance.repository.impl;

import org.springframework.stereotype.Repository;

import com.lxiya.xendercart.product.persistance.repository.SkuRepositoryCustom;

@Repository
public class SkuRepositoryCustomImpl implements SkuRepositoryCustom {

}
// long count = mongoTemplate.count(query, Contract.class);
//         query.with(pageRequest);
//         List<Contract> result = mongoTemplate.find(query, Contract.class);
//         return PageableExecutionUtils.getPage(result, pageRequest, () -> count);



// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class PageView {

//     public PageView(final Page<?> page, final Collection<?> content) {
//         this.setContent(content);
//         this.setTotalElements(page.getTotalElements());
//         this.setTotalPages(page.getTotalPages());
//         this.setNumberOfElements(page.getNumberOfElements());
//         this.setEndOfResult(page.isLast());
//         this.setStartOfResult(page.isFirst());
//     }

//     private Collection<?> content;

//     private long totalElements;

//     private int totalPages;

//     private int numberOfElements;

//     private boolean endOfResult;

//     private boolean startOfResult;
// }