package br.com.home.awscourse.infrastructure.s3;

import br.com.home.awscourse.domain.Note;
import br.com.home.awscourse.infrastructure.storage.Storage;
import com.amazonaws.services.s3.AmazonS3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class S3StorageImpl implements Storage {

    private final AmazonS3 amazonS3;
    private final AWSProperties awsProperties;

    @Override
    public void save(final Note note) {
        var bucketName = awsProperties.getS3BucketName();
        amazonS3.putObject(bucketName, note.getTitle(), note.getContent());
    }

}
