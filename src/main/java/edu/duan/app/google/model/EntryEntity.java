package edu.duan.app.google.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "entry",
        indexes = {
                @Index(name = "idx_title", columnList = "title"),
                @Index(name = "idx_body", columnList = "short_body")
        }
)
@SequenceGenerator(
        name = "entry_generator",
        sequenceName = "entry_generator_seq",
        initialValue = 100,
        allocationSize = 1
)

@Getter
@Setter
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class EntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "b_column_generator")
    private long id;
    @Column(length = 256)
    private String title;
    @Column(length = 2000, unique = true, nullable = false)
    private String shortBody;
}
