package com.mjc.school.repository.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class NewsModel {
    private long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private long authorId;

    public NewsModel() {
    }

    public NewsModel(long id, String title, String content, LocalDateTime createDate, LocalDateTime lastUpdateDate, long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.authorId = authorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
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
        NewsModel newsModel = (NewsModel) o;
        return id == newsModel.id && authorId == newsModel.authorId && title.equals(newsModel.title) && content.equals(newsModel.content) && createDate.equals(newsModel.createDate) && lastUpdateDate.equals(newsModel.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, createDate, lastUpdateDate, authorId);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", title='" + title +
                ", content='" + content +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", authorId=" + authorId;
    }
}
