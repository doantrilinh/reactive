package com.example.reactive.repository;

import com.example.reactive.entity.Md;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MdRepo extends ReactiveCrudRepository<Md, Long> {

    @Query("""
          SELECT md.MD_CURRENCY, md.MD_DEAL_NO
          FROM MD mD
          WHERE md.MD_DEAL_NO = :mdDealNo
          AND ROWNUM = 1
            """)
    Mono<Md> findByMdDealNo(String mdDealNo);

}
