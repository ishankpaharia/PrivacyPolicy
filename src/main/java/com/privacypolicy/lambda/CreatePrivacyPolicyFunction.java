package com.privacypolicy.lambda;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreatePrivacyPolicyFunction implements RequestHandler<UrlTable, String> {

	@Override
	public String handleRequest(UrlTable urlTable, Context context) {

		context.getLogger().log("Initiating CreatePrivacyPolicyFunction-handleRequest..."+ urlTable.toString());

		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
		DynamoDBMapper mapper = new DynamoDBMapper(client);

		mapper.save(urlTable);

		context.getLogger().log("Returning Username: \"" + urlTable.getUsername() + "\"");
		return urlTable.getUsername();
	}
}