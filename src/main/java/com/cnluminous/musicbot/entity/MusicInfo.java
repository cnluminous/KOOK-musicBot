package com.cnluminous.musicbot.entity;

/**
 * @author CNLuminous
 */
public class MusicInfo {
    String name;
    String author;
    String album;
    String id;
    String addUserId;

    public MusicInfo(String name, String author, String album,String id,String addUserId) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.album = album;
        this.addUserId = addUserId;
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(String id) {
        this.id = id;
    }
}
