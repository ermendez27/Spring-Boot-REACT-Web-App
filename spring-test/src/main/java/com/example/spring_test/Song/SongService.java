package com.example.spring_test.Song;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class SongService {

        private final SongRepository songRepository;

        @Autowired
        public SongService(SongRepository songRepository) {
                this.songRepository = songRepository;
        }

        public List<Song> getSongs() {
                return songRepository.findAll();
        }

        public void addNewSong(Song song) {
                Optional<Song> songOptional = songRepository.findSongByName(song.getName());

                if (songOptional.isPresent()) {
                        throw new IllegalStateException("name taken");
                }

                songRepository.save(song);

        }

        public void deleteSong(Long songId) {
                boolean exists = songRepository.existsById(songId);

                if (!exists) {
                        throw new IllegalStateException("no song found matching id");
                }
                songRepository.deleteById(songId);

        }

        @Transactional
        public void updateSong(Long songId, Integer stream_count) {

                Song song = songRepository.findById(songId)
                                .orElseThrow(() -> new IllegalStateException("no song found matching id"));

                if (stream_count != null && stream_count > 0 && song.getStream_count() != stream_count) {
                        song.setStream_count(stream_count);
                        System.out.println("did it");
                }

        }

}
