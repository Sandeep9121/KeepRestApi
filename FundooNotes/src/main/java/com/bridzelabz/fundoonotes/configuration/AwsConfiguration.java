//package com.bridzelabz.fundoonotes.configuration;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//@Configuration
//public class AwsConfiguration {
//    @Value("${aws.keyId}")
//    private String awsKeyId;
//
//    @Value("${aws.secretekey}")
//    private String awsSecretekey;
//
//    @Value("${aws.region}")
//    private String region;
//
//    @Bean
//    public AmazonS3 awsS3Client() {
//        BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsKeyId, awsSecretekey);
//        return AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(region))
//                .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
//    }
//}
//
//
