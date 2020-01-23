package com.amazonaws.samples;

import java.io.File;
import java.util.List;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class S3Exemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String accessKey = "SUA_ACCESS_KEY_AKI";
		String secretKey = "SUA_SECRET_KEY_AKI";

		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.withRegion(Regions.SA_EAST_1).build();
		
//		System.out.println("Criando bucket ...");
		String bucketName = "alura-s3-sdk";
//		s3.createBucket(bucketName);
		
		System.out.println("Listando buckets ...");
		List<Bucket> buckets = s3.listBuckets();
		for (Bucket bucket : buckets) {
			System.out.println(bucket.getName());
		}
		
//		System.out.println("Enviando arquivo...");
//		File file = new File("amazon.png");
//		s3.putObject(bucketName,"amazon-s3.png", file);
//		
		System.out.println("Listando objetos do bucket ...");
		ListObjectsRequest withBucketName = new ListObjectsRequest().withBucketName(bucketName);
		ObjectListing listObjects = s3.listObjects(withBucketName);
		for (S3ObjectSummary objectSummary : listObjects.getObjectSummaries()) {
			System.out.println("*" + objectSummary.getKey() +" - "+ objectSummary.getSize());
		}
		
//		System.out.println("Deletando objeto ...");
//		s3.deleteObject(bucketName, "amazon-s3.png");
//		
//		System.out.println("Listando objetos do bucket ...");
//		ObjectListing listObjects2 = s3.listObjects(withBucketName);
//		for (S3ObjectSummary objectSummary : listObjects2.getObjectSummaries()) {
//			System.out.println("*" + objectSummary.getKey() +" - "+ objectSummary.getSize());
//		}
		
		//s3.deleteBucket(bucketName);
		
		
		
	}

}
