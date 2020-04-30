//package com.bridzelabz.fundoonotes.services;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import com.amazonaws.services.s3.model.S3Object;
//import com.bridzelabz.fundoonotes.model.ProfileEntity;
//
//public interface IProfileService {
//   ProfileEntity storeobjectInS3(MultipartFile file,String filename, String contentType, String Token);
//   ProfileEntity updateObjectinS3(MultipartFile file,String filename, String contentType, String Token);
//   S3Object fetchObject(String awsFileName);
//}
