package sdcc2018.storm.entity.mongodb;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import sdcc2018.storm.entity.Costant;

import java.io.InputStream;
import java.util.Properties;

public class CreatorIntersection {
    private Properties properties;
    public CreatorIntersection()throws Exception{
        properties=new Properties();
        InputStream is=this.getClass().getResourceAsStream("/config.properties");
        properties.load(is);
    }
    public static void main(String args[])throws Exception{
        CreatorIntersection creator=new CreatorIntersection();
        MongoClientURI connectionString = new MongoClientURI(creator.properties.getProperty("urlMongoDB"));
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase(creator.properties.getProperty("mongoDBName"));
        MongoCollection<Document> bookmarksCollection = database.getCollection("sdccIntersection");
        Document document;
        IntersectionGUI intersectionGUI=null;
        ObjectMapper objectMapper=new ObjectMapper();
        for(int id=0;id< Costant.N_INTERSECTIONS;id++){
            CustomSensor customSensor[]=new CustomSensor[4];
            for(int j=0;j<4;j++){
                double saturation=0;
                double latitude=1;
                double longitude=2;
                customSensor[j]=new CustomSensor(id,j,saturation,latitude,longitude);
            }
            intersectionGUI=new IntersectionGUI(customSensor,id,CustomPhase.randomPhase());
            JsonNode jsonNode=objectMapper.valueToTree(intersectionGUI);
            System.out.println(jsonNode);
            document = Document.parse(jsonNode.toString() );
            bookmarksCollection.insertOne(document);
        }
        return;
    }
}