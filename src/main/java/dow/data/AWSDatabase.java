package dow.data;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfilesConfigFile;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

/**
 * Created by steve on 10/18/15.
 */
public class AWSDatabase {
    private DynamoDBMapper mapper;

    public AWSDatabase() {
        AWSCredentials credentials = new ProfilesConfigFile().getCredentials("steve");
        AmazonDynamoDB aws = new AmazonDynamoDBClient(credentials);
        aws.setRegion(Region.getRegion(Regions.US_WEST_2));
        mapper = new DynamoDBMapper(aws);
    }

    DynamoDBMapper getMapper(){
        return mapper;
    }
}
