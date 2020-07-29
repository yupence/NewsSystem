package com.zr.dao;

import com.zr.po.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NewsDao extends JpaRepository <News,Long> , JpaSpecificationExecutor<News> {
}