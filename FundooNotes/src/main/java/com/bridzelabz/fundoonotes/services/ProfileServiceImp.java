//package com.bridzelabz.fundoonotes.services;
//
//import java.io.IOException;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import com.amazonaws.AmazonClientException;
//import com.amazonaws.AmazonServiceException;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.GetObjectRequest;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.S3Object;
//import com.bridzelabz.fundoonotes.model.ProfileEntity;
//import com.bridzelabz.fundoonotes.model.UsersEntity;
//import com.bridzelabz.fundoonotes.repository.IProfilePicRepository;
//import com.bridzelabz.fundoonotes.repository.UsersRepository;
//import com.bridzelabz.fundoonotes.utility.JWTGenerator;
//
//import lombok.extern.slf4j.Slf4j;
//@Service
//@Slf4j
//public class ProfileServiceImp implements IProfileService {
//	@Autowired
//	private IProfilePicRepository profileRepo;
//	@Autowired
//	private JWTGenerator generateToken;
//	@Autowired
//	private UsersRepository userRepository;
//	@Value("${aws.bucketname}")
//	private String bucketName;
//	@Autowired
//	private AmazonS3 amazonS3Client;
//
//	@Transactional
//	public ProfileEntity storeobjectInS3(MultipartFile file, String filename, String contentType, String Token) {
//		try {
//			Long userId = generateToken.parseJWTToken(Token);
//			UsersEntity user = userRepository.getusersByid(userId);
//			if (user != null) {
//				ProfileEntity profile = new ProfileEntity(filename, user);
//				ObjectMetadata objMetaData = new ObjectMetadata();
//				objMetaData.setContentType(contentType);
//				objMetaData.setContentLength(file.getSize());
//				amazonS3Client.putObject(bucketName, filename, file.getInputStream(), objMetaData);
//				profileRepo.save(profile);
//				return profile;
//			}
//		} catch (AmazonClientException | IOException e) {
//			throw new RuntimeException("Error while uploading file.....!");
//		}
//		return null;
//	}
//
//	@Transactional
//	public S3Object fetchObject(String awsFileName) {
//		S3Object s3object;
//		try {
//			s3object = amazonS3Client.getObject(new GetObjectRequest(bucketName, awsFileName));
//		} catch (AmazonServiceException e) {
//			throw new RuntimeException("Error while streaming the file.....!");
//		} catch (AmazonClientException e) {
//			throw new RuntimeException("Error while streaming the file.....!");
//		}
//		return s3object;
//	}
//
//	public void deleteObject(String key) {
//		try {
//			amazonS3Client.deleteObject(bucketName, key);
//		} catch (AmazonServiceException serviceException) {
//			log.error(serviceException.getErrorMessage());
//		} catch (AmazonClientException exception) {
//			log.error("Error while deleting File.");
//		}
//	}
//
//	@Transactional
//	public ProfileEntity updateObjectinS3(MultipartFile file, String filename, String contentType, String Token) {
//
//		try {
//			Long userId = generateToken.parseJWTToken(Token);
//			UsersEntity user = userRepository.getusersByid(userId);
//			ProfileEntity profile = profileRepo.findByUserid(userId);
//			if (user != null && profile != null) {
//				deleteObject(profile.getProfilePictureName());
//				profileRepo.delete(profile);
//				ObjectMetadata objectMetadata = new ObjectMetadata();
//				objectMetadata.setContentType(contentType);
//				objectMetadata.setContentLength(file.getSize());
//				amazonS3Client.putObject(bucketName, filename, file.getInputStream(), objectMetadata);
//				profileRepo.save(profile);
//				return profile;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//}
