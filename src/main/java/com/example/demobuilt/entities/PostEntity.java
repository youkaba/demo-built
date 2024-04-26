package com.example.demobuilt.entities;

import com.example.demobuilt.metadata.dto.PostDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class PostEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDateTime dateTime;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity categoryEntity;

    public PostDTO toDto() {
        return new PostDTO(id, title, content, dateTime, categoryEntity.getId());
    }

}
