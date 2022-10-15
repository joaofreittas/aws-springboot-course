package br.com.home.awscourse.infrastructure.s3;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class AWSProperties {

    @Value("${aws.access-key-id}")
    private String accessKey;

    @Value("${aws.secret-access-key}")
    private String secretAccessKey;

    @Value("${aws.s3.region}")
    private String s3Region;

    @Value("${aws.s3.bucket-name}")
    private String s3BucketName;

}
