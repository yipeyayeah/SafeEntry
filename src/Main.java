import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import user.User;
import user.UserDataController;

public class Main {

	public static void main(String[] args) {

		ConnectionString connectionString = new ConnectionString("mongodb+srv://root:gideon97@mycluster2.j0hmg.mongodb.net/test?retryWrites=true&w=majority" );
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                                                                .applyConnectionString(connectionString)
                                                                .codecRegistry(codecRegistry)
                                                                .build();
        
        try (com.mongodb.client.MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("SafeEntry");
            MongoCollection<User> collection = db.getCollection("UsersData", User.class);

            // Self checkin test
//            User user = new User("Bernie", "S9722334B", "Bernie.com");
//            UserDataController controller = new UserDataController();
//            boolean rs = controller.selfCheckIn(user, collection);
//	       	  System.out.println(rs);  
            

            
            
            //Self checkout test
//            User user = new User("Gideon", "S9711228B", "Compassvale Street");
//            UserDataController controller = new UserDataController();
//            boolean rs = controller.selfCheckOut(user, collection);
//            System.out.println(rs);  

        }
	}

}
