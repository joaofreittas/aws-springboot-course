package br.com.home.awscourse.application;

import br.com.home.awscourse.domain.Note;
import br.com.home.awscourse.infrastructure.s3.AWSProperties;
import br.com.home.awscourse.infrastructure.storage.Storage;
import com.amazonaws.services.s3.AmazonS3;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    private final Storage storage;

    @PostMapping
    public ResponseEntity<Note> save(@RequestBody Note note) {
        storage.save(note);
        return ResponseEntity.status(CREATED).build();
    }

}
