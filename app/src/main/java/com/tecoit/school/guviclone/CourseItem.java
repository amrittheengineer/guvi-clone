package com.tecoit.school.guviclone;

public class CourseItem {
    private String title;
    private int viewType;

    public int getViewType() {
        return viewType;
    }

    public CourseItem(String title, int viewType) {
        this.title = title;
        this.viewType = viewType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static class CourseItemHeader extends CourseItem {
        public CourseItemHeader(String title) {
            super(title, CoursesAdapter.TYPE_HEADER);
        }
    }

    public static class CourseItemContent extends CourseItem {
        private boolean active;
        private String videoId = "";

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public String getVideoId() {
            return videoId;
        }

        public CourseItemContent(String title, String videoId) {
            super(title, CoursesAdapter.TYPE_CONTENT);
            this.videoId = videoId;
            this.active = false;
        }
        public CourseItemContent(String title, String videoId, boolean active) {
            super(title, CoursesAdapter.TYPE_CONTENT);
            this.videoId = videoId;
            this.active = active;
        }
    }
}
