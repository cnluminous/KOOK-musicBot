package com.cnluminous.musicbot.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserVoiceChannelEntity {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataDTO data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        @SerializedName("items")
        private List<ItemsDTO> items;
        @SerializedName("meta")
        private MetaDTO meta;
        @SerializedName("sort")
        private SortDTO sort;

        public List<ItemsDTO> getItems() {
            return items;
        }

        public void setItems(List<ItemsDTO> items) {
            this.items = items;
        }

        public MetaDTO getMeta() {
            return meta;
        }

        public void setMeta(MetaDTO meta) {
            this.meta = meta;
        }

        public SortDTO getSort() {
            return sort;
        }

        public void setSort(SortDTO sort) {
            this.sort = sort;
        }

        public static class MetaDTO {
            @SerializedName("page")
            private int page;
            @SerializedName("page_total")
            private int pageTotal;
            @SerializedName("page_size")
            private int pageSize;
            @SerializedName("total")
            private int total;

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public int getPageTotal() {
                return pageTotal;
            }

            public void setPageTotal(int pageTotal) {
                this.pageTotal = pageTotal;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class SortDTO {
        }

        public static class ItemsDTO {
            @SerializedName("id")
            private String id;
            @SerializedName("guild_id")
            private String guildId;
            @SerializedName("master_id")
            private String masterId;
            @SerializedName("parent_id")
            private String parentId;
            @SerializedName("user_id")
            private String userId;
            @SerializedName("name")
            private String name;
            @SerializedName("topic")
            private String topic;
            @SerializedName("type")
            private int type;
            @SerializedName("level")
            private int level;
            @SerializedName("slow_mode")
            private int slowMode;
            @SerializedName("last_msg_content")
            private String lastMsgContent;
            @SerializedName("last_msg_id")
            private String lastMsgId;
            @SerializedName("has_password")
            private boolean hasPassword;
            @SerializedName("limit_amount")
            private int limitAmount;
            @SerializedName("is_category")
            private boolean isCategory;
            @SerializedName("permission_sync")
            private int permissionSync;
            @SerializedName("permission_overwrites")
            private List<PermissionOverwritesDTO> permissionOverwrites;
            @SerializedName("permission_users")
            private List<?> permissionUsers;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getGuildId() {
                return guildId;
            }

            public void setGuildId(String guildId) {
                this.guildId = guildId;
            }

            public String getMasterId() {
                return masterId;
            }

            public void setMasterId(String masterId) {
                this.masterId = masterId;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTopic() {
                return topic;
            }

            public void setTopic(String topic) {
                this.topic = topic;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getSlowMode() {
                return slowMode;
            }

            public void setSlowMode(int slowMode) {
                this.slowMode = slowMode;
            }

            public String getLastMsgContent() {
                return lastMsgContent;
            }

            public void setLastMsgContent(String lastMsgContent) {
                this.lastMsgContent = lastMsgContent;
            }

            public String getLastMsgId() {
                return lastMsgId;
            }

            public void setLastMsgId(String lastMsgId) {
                this.lastMsgId = lastMsgId;
            }

            public boolean isHasPassword() {
                return hasPassword;
            }

            public void setHasPassword(boolean hasPassword) {
                this.hasPassword = hasPassword;
            }

            public int getLimitAmount() {
                return limitAmount;
            }

            public void setLimitAmount(int limitAmount) {
                this.limitAmount = limitAmount;
            }

            public boolean isIsCategory() {
                return isCategory;
            }

            public void setIsCategory(boolean isCategory) {
                this.isCategory = isCategory;
            }

            public int getPermissionSync() {
                return permissionSync;
            }

            public void setPermissionSync(int permissionSync) {
                this.permissionSync = permissionSync;
            }

            public List<PermissionOverwritesDTO> getPermissionOverwrites() {
                return permissionOverwrites;
            }

            public void setPermissionOverwrites(List<PermissionOverwritesDTO> permissionOverwrites) {
                this.permissionOverwrites = permissionOverwrites;
            }

            public List<?> getPermissionUsers() {
                return permissionUsers;
            }

            public void setPermissionUsers(List<?> permissionUsers) {
                this.permissionUsers = permissionUsers;
            }

            public static class PermissionOverwritesDTO {
                @SerializedName("role_id")
                private int roleId;
                @SerializedName("allow")
                private int allow;
                @SerializedName("deny")
                private int deny;

                public int getRoleId() {
                    return roleId;
                }

                public void setRoleId(int roleId) {
                    this.roleId = roleId;
                }

                public int getAllow() {
                    return allow;
                }

                public void setAllow(int allow) {
                    this.allow = allow;
                }

                public int getDeny() {
                    return deny;
                }

                public void setDeny(int deny) {
                    this.deny = deny;
                }
            }
        }
    }
}
