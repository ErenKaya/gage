package com.ing.gage.model.entities.notification;

import com.ing.gage.model.entities.user.DigitalUser;
import com.ing.gage.model.enums.notification.NotificationType;
import jakarta.persistence.*;

@Entity
@Table(name = "transfer")
public class Notification {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private DigitalUser digitalUser;

    private String title;

    private String content;

    private NotificationType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DigitalUser getDigitalUser() {
        return digitalUser;
    }

    public void setDigitalUser(DigitalUser digitalUser) {
        this.digitalUser = digitalUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }
}
