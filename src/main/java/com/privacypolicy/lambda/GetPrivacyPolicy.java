package com.privacypolicy.lambda;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.ArrayList;
import java.util.List;

public class GetPrivacyPolicy implements RequestHandler<UrlTable, List<UrlTable>> {

	@Override
	public List<UrlTable> handleRequest(UrlTable urlTable, Context context) {
		context.getLogger().log("Initiating GetPrivacyPolicy-handleRequest...");

		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
		DynamoDBMapper mapper = new DynamoDBMapper(client);

		DynamoDBQueryExpression<UrlTable> queryExpression
				= new DynamoDBQueryExpression<UrlTable>().withHashKeyValues(urlTable);

		try {
			List<UrlTable> urlTableList = mapper.query(UrlTable.class, queryExpression);

			for (UrlTable n : urlTableList) {
				context.getLogger().log("Note found in DynamoDB: {" + n.toString() + "}");
			}

			return urlTableList;
		} catch (Exception e) {
			context.getLogger().log("Exception found, returning empty list. Error: " + e.getMessage());
			return new ArrayList<UrlTable>();
		}
	}
}
