package com.example.my_diary.domain.marker;

import com.example.my_diary.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Marker {

    @Id
    @Column(name = "MARKER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placeName;

    private String placeContent;

    private Double lat;

    private Double lng;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public void addToUser(User user) {
        this.user = user;
        if(!user.getMarkers().contains(this)) {
            user.getMarkers().add(this);
        }
    }

    @Builder
    public Marker(String placeName, String placeContent, Double lat, Double lng) {
        this.placeName = placeName;
        this.placeContent = placeContent;
        this.lat = lat;
        this.lng = lng;
    }
}
