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

    public String getTitle() {
        return title;
    }

    public static class CourseItemHeader extends CourseItem {
        public CourseItemHeader(String title) {
            super(title, CoursesAdapter.TYPE_HEADER);
        }
    }

    public static class CourseItemContent extends CourseItem {
        private boolean active = false;

        public boolean isActive() {
            return active;
        }

        public CourseItemContent(String title) {
            super(title, CoursesAdapter.TYPE_CONTENT);
        }
        public CourseItemContent(String title, boolean active) {
            super(title, CoursesAdapter.TYPE_CONTENT);
            this.active = active;
        }
    }
}
