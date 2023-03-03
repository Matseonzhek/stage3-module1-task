package com.mjc.school.service.dto;

import java.util.Objects;

public class NewsDto {
    private Long id;
    private String title;
    private String content;
    private long authorId;

    public NewsDto(String title, String content, long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    public NewsDto(Long id, String title, String content, long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    public NewsDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsDto newsDTO = (NewsDto) o;
        return authorId == newsDTO.authorId && title.equals(newsDTO.title) && content.equals(newsDTO.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, authorId);
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", authorId=" + authorId;
    }
}
