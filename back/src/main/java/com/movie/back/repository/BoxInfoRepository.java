package com.movie.back.repository;

import com.movie.back.entity.BoxInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxInfoRepository extends JpaRepository<BoxInfo,String> {
}
