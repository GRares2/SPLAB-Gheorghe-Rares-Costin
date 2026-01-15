package com.example.moviemanagement.services;

import com.example.moviemanagement.models.Director;
import com.example.moviemanagement.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    public Optional<Director> getDirectorById(Long id) {
        return directorRepository.findById(id);
    }

    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    public Optional<Director> updateDirector(Long id, Director updatedDirector) {
        return directorRepository.findById(id)
                .map(existingDirector -> {
                    existingDirector.setName(updatedDirector.getName());
                    existingDirector.setBirthYear(updatedDirector.getBirthYear());
                    existingDirector.setNationality(updatedDirector.getNationality());
                    return directorRepository.save(existingDirector);
                });
    }

    public boolean deleteDirector(Long id) {
        if (directorRepository.existsById(id)) {
            directorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}