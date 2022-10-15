package br.com.home.awscourse.infrastructure.storage.config;

import br.com.home.awscourse.infrastructure.s3.AWSProperties;
import br.com.home.awscourse.infrastructure.s3.S3StorageImpl;
import br.com.home.awscourse.infrastructure.storage.Storage;
import com.amazonaws.services.s3.AmazonS3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfiguration {

    @Bean
    public Storage storage(AmazonS3 amazonS3, AWSProperties awsProperties) {
        return new S3StorageImpl(amazonS3, awsProperties);
    }

}
