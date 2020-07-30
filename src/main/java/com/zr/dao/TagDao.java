package com.zr.dao;


import com.zr.po.Tag;
import com.zr.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagDao extends JpaRepository<Tag,Long> {
    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}