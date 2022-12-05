package com.tural.pc.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class VideoCard {

    private String name;
    private String price;
    private String curr;
    private String href;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoCard videoCard = (VideoCard) o;
        return Objects.equals(name, videoCard.name) && Objects.equals(href, videoCard.href);
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(name, href);
    }
}

