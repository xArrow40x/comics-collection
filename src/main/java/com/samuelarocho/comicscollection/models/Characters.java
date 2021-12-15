package com.samuelarocho.comicscollection.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.util.HashSet;

import javax.persistence.*;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;

import lombok.Data;

@Component
@Data
@Entity
@Table(name = "characters")
public class Characters {
    @Id
    @SequenceGenerator(name = "characters_generator", sequenceName = "characters_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "characters_generator")
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column
    private String name;

    @Column
    private String photo_url;
    
    @ManyToMany(mappedby = "characters")
    Set<Comics> comics = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "series_id", nullable = false)
    private Series series;

    @OneToMany
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;
}
