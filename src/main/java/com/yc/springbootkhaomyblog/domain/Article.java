package com.yc.springbootkhaomyblog.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

public class Article {
    private Integer id;
    private String author;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    private String keyWords;
    private String description;
    @Min(1)
    @Max(10)
    private Integer categoryId;
    @NotEmpty
    private String label;
    private String titleImgs;
    private String status;
    private Timestamp createTime;
    private Integer readCnt;
    private Integer agreeCnt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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


    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitleImgs() {
        return titleImgs;
    }

    public void setTitleImgs(String titleImgs) {
        this.titleImgs = titleImgs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getReadCnt() {
        return readCnt;
    }

    public void setReadCnt(Integer readCnt) {
        this.readCnt = readCnt;
    }

    public Integer getAgreeCnt() {
        return agreeCnt;
    }

    public void setAgreeCnt(Integer agreeCnt) {
        this.agreeCnt = agreeCnt;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", keywords='" + keyWords + '\'' +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                ", label='" + label + '\'' +
                ", titleImgs='" + titleImgs + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", readCnt=" + readCnt +
                ", agreeCnt=" + agreeCnt +
                '}';
    }
}
