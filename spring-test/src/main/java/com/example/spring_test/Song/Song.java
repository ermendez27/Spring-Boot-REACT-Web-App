package com.example.spring_test.Song;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Song {
    @Id
    @SequenceGenerator(name = "song_sequence", sequenceName = "song_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "song_sequence")
    private Long id;
    private String name;
    private String artist;
    private LocalDate release_date;
    private Integer stream_count;

    public Song() {
    }

    public Song(Long id, String name, String artist, LocalDate release_date, Integer stream_count) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.release_date = release_date;
        this.stream_count = stream_count;
    }

    public Song(String name, String artist, LocalDate release_date, Integer stream_count) {
        this.name = name;
        this.artist = artist;
        this.release_date = release_date;
        this.stream_count = stream_count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public Integer getStream_count() {
        return stream_count;
    }

    public void setStream_count(Integer stream_count) {
        this.stream_count = stream_count;
    }

    @Override
    public String toString() {
        return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", release_date=" + release_date
                + ", stream_count=" + stream_count + "]";
    }

}
