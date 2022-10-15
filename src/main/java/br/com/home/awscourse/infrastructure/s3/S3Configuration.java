package br.com.home.awscourse.infrastructure.s3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class S3Configuration {

    private final AWSProperties awsProperties;

    @Bean
    public AmazonS3 amazonS3() {
        var secretAccessKey = awsProperties.getSecretAccessKey();
        var accessKey = awsProperties.getAccessKey();
        var s3Region = awsProperties.getS3Region();
        var credentials = new BasicAWSCredentials(accessKey, secretAccessKey);

        return AmazonS3ClientBuilder
            .standard()
            .withRegion(Regions.fromName(s3Region))
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .build();
    }

}
