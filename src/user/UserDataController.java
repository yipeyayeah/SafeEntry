package user;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;

public class UserDataController {
	
	public boolean selfCheckIn(User user,  MongoCollection<User> collection) {
		try {
			// Create a new time instance
		    LocalDateTime now = LocalDateTime.now(); 
			user.setCheckInTime(now);
			user.setCheckOutTime(null);
			// Insert the object into the dB
			collection.insertOne(user);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean selfCheckOut(User user,  MongoCollection<User> collection) {
		try {
			// Create 2 new filters based on the name and location  
            Bson nameFilter = Filters.eq("name", user.getName());
    		Bson locationFilter = Filters.eq("location", user.getLocation());
    		Bson checkOutTimeFilter = Filters.eq("checkOutTime", null);


    		// Find the user based on these filters
    	    User userfound =collection.find(Filters.and(nameFilter, locationFilter,checkOutTimeFilter)).first();
    	    LocalDateTime now = LocalDateTime.now();
    	    // Set the checkout time
    	    userfound.setCheckOutTime(now);
	       
	       
    	   Document filterByGradeId = new Document("_id", userfound.getId());
           FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
           collection.findOneAndReplace(filterByGradeId, userfound, returnDocAfterReplace);

			
           return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
