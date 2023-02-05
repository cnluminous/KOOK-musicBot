package com.cnluminous.musicbot.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author CNLuminous
 */
public class CloudMusicSearchEntity {

    @SerializedName("result")
    private ResultDTO result;
    @SerializedName("code")
    private String code;

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class ResultDTO {
        @SerializedName("songs")
        private List<SongsDTO> songs;
        @SerializedName("hasMore")
        private boolean hasMore;
        @SerializedName("songCount")
        private String songCount;

        public List<SongsDTO> getSongs() {
            return songs;
        }

        public void setSongs(List<SongsDTO> songs) {
            this.songs = songs;
        }

        public boolean isHasMore() {
            return hasMore;
        }

        public void setHasMore(boolean hasMore) {
            this.hasMore = hasMore;
        }

        public String getSongCount() {
            return songCount;
        }

        public void setSongCount(String songCount) {
            this.songCount = songCount;
        }

        public static class SongsDTO {
            @SerializedName("id")
            private String id;
            @SerializedName("name")
            private String name;
            @SerializedName("artists")
            private List<ArtistsDTO> artists;
            @SerializedName("album")
            private AlbumDTO album;
            @SerializedName("duration")
            private String duration;
            @SerializedName("copyrightId")
            private String copyrightId;
            @SerializedName("status")
            private String status;
            @SerializedName("alias")
            private List<?> alias;
            @SerializedName("rtype")
            private String rtype;
            @SerializedName("ftype")
            private String ftype;
            @SerializedName("mvid")
            private String mvid;
            @SerializedName("fee")
            private String fee;
            @SerializedName("rUrl")
            private Object rUrl;
            @SerializedName("mark")
            private String mark;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<ArtistsDTO> getArtists() {
                return artists;
            }

            public void setArtists(List<ArtistsDTO> artists) {
                this.artists = artists;
            }

            public AlbumDTO getAlbum() {
                return album;
            }

            public void setAlbum(AlbumDTO album) {
                this.album = album;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getCopyrightId() {
                return copyrightId;
            }

            public void setCopyrightId(String copyrightId) {
                this.copyrightId = copyrightId;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }

            public String getRtype() {
                return rtype;
            }

            public void setRtype(String rtype) {
                this.rtype = rtype;
            }

            public String getFtype() {
                return ftype;
            }

            public void setFtype(String ftype) {
                this.ftype = ftype;
            }

            public String getMvid() {
                return mvid;
            }

            public void setMvid(String mvid) {
                this.mvid = mvid;
            }

            public String getFee() {
                return fee;
            }

            public void setFee(String fee) {
                this.fee = fee;
            }

            public Object getRUrl() {
                return rUrl;
            }

            public void setRUrl(Object rUrl) {
                this.rUrl = rUrl;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public static class AlbumDTO {
                @SerializedName("id")
                private String id;
                @SerializedName("name")
                private String name;
                @SerializedName("artist")
                private ArtistDTO artist;
                @SerializedName("publishTime")
                private long publishTime;
                @SerializedName("size")
                private String size;
                @SerializedName("copyrightId")
                private String copyrightId;
                @SerializedName("status")
                private String status;
                @SerializedName("picId")
                private long picId;
                @SerializedName("mark")
                private String mark;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public ArtistDTO getArtist() {
                    return artist;
                }

                public void setArtist(ArtistDTO artist) {
                    this.artist = artist;
                }

                public long getPublishTime() {
                    return publishTime;
                }

                public void setPublishTime(long publishTime) {
                    this.publishTime = publishTime;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public String getCopyrightId() {
                    return copyrightId;
                }

                public void setCopyrightId(String copyrightId) {
                    this.copyrightId = copyrightId;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public long getPicId() {
                    return picId;
                }

                public void setPicId(long picId) {
                    this.picId = picId;
                }

                public String getMark() {
                    return mark;
                }

                public void setMark(String mark) {
                    this.mark = mark;
                }

                public static class ArtistDTO {
                    @SerializedName("id")
                    private String id;
                    @SerializedName("name")
                    private String name;
                    @SerializedName("picUrl")
                    private Object picUrl;
                    @SerializedName("alias")
                    private List<?> alias;
                    @SerializedName("albumSize")
                    private String albumSize;
                    @SerializedName("picId")
                    private String picId;
                    @SerializedName("img1v1Url")
                    private String img1v1Url;
                    @SerializedName("img1v1")
                    private String img1v1;
                    @SerializedName("trans")
                    private Object trans;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public Object getPicUrl() {
                        return picUrl;
                    }

                    public void setPicUrl(Object picUrl) {
                        this.picUrl = picUrl;
                    }

                    public List<?> getAlias() {
                        return alias;
                    }

                    public void setAlias(List<?> alias) {
                        this.alias = alias;
                    }

                    public String getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(String albumSize) {
                        this.albumSize = albumSize;
                    }

                    public String getPicId() {
                        return picId;
                    }

                    public void setPicId(String picId) {
                        this.picId = picId;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url;
                    }

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public String getImg1v1() {
                        return img1v1;
                    }

                    public void setImg1v1(String img1v1) {
                        this.img1v1 = img1v1;
                    }

                    public Object getTrans() {
                        return trans;
                    }

                    public void setTrans(Object trans) {
                        this.trans = trans;
                    }
                }
            }

            public static class ArtistsDTO {
                @SerializedName("id")
                private String id;
                @SerializedName("name")
                private String name;
                @SerializedName("picUrl")
                private Object picUrl;
                @SerializedName("alias")
                private List<?> alias;
                @SerializedName("albumSize")
                private String albumSize;
                @SerializedName("picId")
                private String picId;
                @SerializedName("img1v1Url")
                private String img1v1Url;
                @SerializedName("img1v1")
                private String img1v1;
                @SerializedName("trans")
                private Object trans;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Object getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(Object picUrl) {
                    this.picUrl = picUrl;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }

                public String getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(String albumSize) {
                    this.albumSize = albumSize;
                }

                public String getPicId() {
                    return picId;
                }

                public void setPicId(String picId) {
                    this.picId = picId;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public String getImg1v1() {
                    return img1v1;
                }

                public void setImg1v1(String img1v1) {
                    this.img1v1 = img1v1;
                }

                public Object getTrans() {
                    return trans;
                }

                public void setTrans(Object trans) {
                    this.trans = trans;
                }
            }
        }
    }
}
