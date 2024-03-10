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
}
