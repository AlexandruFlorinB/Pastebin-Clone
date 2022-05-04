package com.example.Pastebin;

import javax.persistence.*;

@Entity
@Table(name = "public.paste")
public class Paste {
    @Id
    @SequenceGenerator(
            name = "paste_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "paste_sequence",
            strategy = GenerationType.SEQUENCE
    )

    private Long id;
    private String title;
    private String text;

    public Paste() {}

    public Paste(Long id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
