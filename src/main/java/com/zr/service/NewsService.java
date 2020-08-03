package com.zr.service;

import com.zr.po.NewQuery;
import com.zr.po.News;
import com.zr.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface NewsService {
    Page<News>  findByPageable(Pageable pageable);

    void input(News news);

    News findNewsById(Long id);

    Page<News> searchNews(Pageable pageable, NewQuery newQuery);

    Page<News> searchNews(Pageable pageable, Long id);

    void deleteById(Long id);

    Long countNews();

    HashMap<String, List<News>> archiveNews();

    Page<News> findNewsByQuery(String query, Pageable pageable);

    List<News> findTop(int i);
}
