package com.mjc.school.controller.entity;

import java.util.Objects;

public class NewsDTO {
    private String title;
    private String content;
    private long authorId;

    public NewsDTO(String title, String content, long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
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
        NewsDTO newsDTO = (NewsDTO) o;
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
