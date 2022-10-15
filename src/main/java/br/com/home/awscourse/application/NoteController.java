package br.com.home.awscourse.application;

import br.com.home.awscourse.domain.Note;
import br.com.home.awscourse.infrastructure.s3.AWSProperties;
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

    private final AmazonS3 amazonS3;
    private final AWSProperties awsProperties;

    @PostMapping
    public ResponseEntity<Note> save(@RequestBody Note note) {
        var bucketName = awsProperties.getS3BucketName();
        amazonS3.putObject(bucketName, note.getTitle(), note.getContent());

        return ResponseEntity.status(CREATED).build();
    }

}
