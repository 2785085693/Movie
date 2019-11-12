package com.bawie.movie.model.bean;

import java.util.List;

public class FindBean {


    /**
     * result : [{"commentContent":"一给我类giaogiao","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-09-20/20190920171536.png","commentId":2143,"commentTime":1573216411000,"commentUserId":13627,"commentUserName":"吴浩然","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":9.9},{"commentContent":"真尼玛好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-20/20191020113143.jpeg","commentId":2141,"commentTime":1573216258000,"commentUserId":13710,"commentUserName":"遇上方知有","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5},{"commentContent":"电影好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-25/20191025153434.jpg","commentId":2136,"commentTime":1573215304000,"commentUserId":13709,"commentUserName":"郝甜甜","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"站好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-25/20191025154434.jpg","commentId":2133,"commentTime":1573215014000,"commentUserId":13712,"commentUserName":"大明星","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"我郭昊坤不服","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-09-07/20190907140903.jpg","commentId":2123,"commentTime":1573003032000,"commentUserId":13472,"commentUserName":"红衣佳人白衣友","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":9.4},{"commentContent":"唉唉唉","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-18/20191018200515.txt","commentId":2025,"commentTime":1572868468000,"commentUserId":13714,"commentUserName":"run","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5.1},{"commentContent":"","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-23/20191023184812.jpg","commentId":1916,"commentTime":1572860165000,"commentUserId":13708,"commentUserName":"郭转晨","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":10},{"commentContent":"��Ӱ�ÿ�","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":209,"commentTime":1569377417000,"commentUserId":13458,"commentUserName":"23","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commentContent : 一给我类giaogiao
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/2019-09-20/20190920171536.png
         * commentId : 2143
         * commentTime : 1573216411000
         * commentUserId : 13627
         * commentUserName : 吴浩然
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 9.9
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int isGreat;
        private int replyNum;
        private double score;
        private List<?> replyHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<?> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<?> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
