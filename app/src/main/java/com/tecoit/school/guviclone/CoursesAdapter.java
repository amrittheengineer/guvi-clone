package com.tecoit.school.guviclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_CONTENT = 1;

    private Context context;
    private List<CourseItem> courseItems;
    private OnClickListener listener;

    public CoursesAdapter(Context context, List<CourseItem> courseItems, OnClickListener listener) {
        this.context = context;
        this.courseItems = courseItems;
        this.listener = listener;
    }

    public interface OnClickListener{
        void onClick(String videoId, int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(context).inflate(R.layout.layout_course_header, parent, false);
            return new HeaderViewHolder(v);
        } else if (viewType == TYPE_CONTENT){
            View v = LayoutInflater.from(context).inflate(R.layout.layout_course_content, parent, false);
            return new ContentViewHolder(v);
        }
        else
            throw new RuntimeException("Could not inflate layout");
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (holder instanceof ContentViewHolder){
            ContentViewHolder contentView = ((ContentViewHolder) holder);
            final CourseItem.CourseItemContent contentData = ((CourseItem.CourseItemContent) courseItems.get(position));

            contentView.title.setText(contentData.getTitle());

            if (contentData.isActive()){
                contentView.active.setVisibility(View.VISIBLE);
                contentView.course_content_card.setCardElevation(8);
            }else {
                contentView.active.setVisibility(View.GONE);
                contentView.course_content_card.setCardElevation(0);
            }
            contentView.course_content_card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(contentData.getVideoId(), position);
                }
            });
        } else if (holder instanceof  HeaderViewHolder){
            HeaderViewHolder contentView = ((HeaderViewHolder) holder);
            CourseItem.CourseItemHeader contentData = ((CourseItem.CourseItemHeader) courseItems.get(position));

            contentView.headerTitle.setText(contentData.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return courseItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return courseItems.get(position).getViewType();
    }

    static class ContentViewHolder extends ViewHolder{
        public TextView title;
        public RelativeLayout active;
        public CardView course_content_card;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.content_title);
            active = itemView.findViewById(R.id.active_content);
            course_content_card = itemView.findViewById(R.id.course_content_card);
        }
    }
    static class HeaderViewHolder extends ViewHolder{
        public TextView headerTitle;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            headerTitle = itemView.findViewById(R.id.course_title);
        }
    }
}
