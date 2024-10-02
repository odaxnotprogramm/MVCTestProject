package org.sab1maru.web.mvctestproject.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Table(name = "clubs_db")
@NoArgsConstructor
@AllArgsConstructor
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String photoUrl;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //    @CreationTimestamp
//    private LocalDateTime createdOn;
//    @UpdateTimestamp
//    private LocalDateTime updatedOn;
}
